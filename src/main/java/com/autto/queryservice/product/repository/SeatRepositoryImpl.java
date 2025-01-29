package com.autto.queryservice.product.repository;

import com.autto.queryservice.product.dto.ProductInventoryDto;
import com.autto.queryservice.product.dto.ReservedProductDetailDto;
import com.autto.queryservice.product.dto.ReservedProductDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import com.autto.queryservice.product.dto.*;

import static com.autto.queryservice.product.entity.QProduct.product;
import static com.autto.queryservice.product.entity.QSeatByDateInventory.seatByDateInventory;

import java.util.List;
import java.util.UUID;

public class SeatRepositoryImpl implements SeatDslRepository {
    private final JPAQueryFactory queryFactory;

    public SeatRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ProductInventoryDto> findSeatInfos(UUID productID) {
        return (List<ProductInventoryDto>) queryFactory
                .select(new QProductInventoryDto(seatByDateInventory.id, product.title, product.location, product.performStartDate, product.performEndDate, seatByDateInventory.date, seatByDateInventory.totalSeats.subtract(seatByDateInventory.reservedSeats),seatByDateInventory.price, seatByDateInventory.status))
                .from(seatByDateInventory)
                .where(seatByDateInventory.product.id.eq(productID))
                .leftJoin(product).on(seatByDateInventory.product.id.eq(product.id))
                .fetch();
    }

    @Override
    public ReservedProductDto findSeatBySeatId(UUID seatId) {
        return queryFactory
                .select(new QReservedProductDto(seatByDateInventory.date, product.title, product.thumbnailUrl))
                .from(seatByDateInventory)
                .where(seatByDateInventory.id.eq(seatId))
                .leftJoin(product).on(seatByDateInventory.product.id.eq(product.id))
                .fetchOne();
    }

    @Override
    public ReservedProductDetailDto findProductDetailBySeatId(UUID seatId) {
        return queryFactory
                .select(new QReservedProductDetailDto(product.title, product.posterUrl, product.location, seatByDateInventory.date, seatByDateInventory.price))
                .from(seatByDateInventory)
                .where(seatByDateInventory.id.eq(seatId))
                .leftJoin(product).on(seatByDateInventory.product.id.eq(product.id))
                .fetchOne();
    }
}
