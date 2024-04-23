package org.reservation.rentalms_kotlin

import org.reservation.rentalms_kotlin.model.RentalCard
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.stream.Collectors

@SpringBootApplication
class RentalMsKotlinApplication

fun main(args: Array<String>) {
    domainTest();
    runApplication<RentalMsKotlinApplication>(*args)
}

fun domainTest() {
    println("------------- 도메인 모델 테스트 진행 -------------");
    val sampleCard = RentalCard.sample()
    showCardStatus(sampleCard);
}

private fun showCardStatus(card: RentalCard) {
    println("$".repeat(50))
    println("% %${card.member?.name} 도서카드 ")
    println("% %대여도서 연체상태 : ${card.rentalItemList.map { it.overdued }}")
    println("% %총연체료: ${card.lateFee.point}")
    println("% %대여가능여부: ${card.rentStatus}")
    println("% %대여 목록")
    println("% %${card.rentalItemList.map { it.item?.title }}")
    println("% %반납목록")
    println("% %${card.returnItemList.map { it.rentalItem.item?.title }}")
    println("$".repeat(50))
}