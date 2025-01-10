package ottua.queryservice.auth.jwt;

import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import ottua.queryservice.auth.provider.JwtTokenProvider;
import ottua.queryservice.common.response.ErrorResponseStatus;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean{
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = resolveToken((HttpServletRequest) servletRequest);

        try {
            if (token != null && jwtTokenProvider.validateToken(token)){
                Authentication authentication = jwtTokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (SecurityException | MalformedJwtException | IllegalArgumentException e) {
            servletRequest.setAttribute("exception", ErrorResponseStatus.WRONG_TYPE_TOKEN);
        } catch (ExpiredJwtException e) {
            servletRequest.setAttribute("exception", ErrorResponseStatus.EXPIRED_TOKEN);
        } catch (UnsupportedJwtException e) {
            servletRequest.setAttribute("exception", ErrorResponseStatus.UNSUPPORTED_TOKEN);
        } catch (SignatureException e) {
            servletRequest.setAttribute("exception", ErrorResponseStatus.WRONG_SIGNATURE);
        } catch (Exception e) {
            servletRequest.setAttribute("exception", ErrorResponseStatus.UNKNOWN_ERROR);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
