SELECT
    car.CAR_ID,
    car.CAR_TYPE,
    -- 대여료 x 30일 x 내야할 비율 = 요금
    -- (100 - 할인률)/100 = 내야할 비율
    ROUND(car.DAILY_FEE * 30 * (100 - plan.DISCOUNT_RATE) / 100) AS FEE  -- 지불 비용
FROM CAR_RENTAL_COMPANY_CAR AS car
    INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS history
        ON car.CAR_ID = history.CAR_ID
    INNER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS plan
        ON car.CAR_TYPE = plan.CAR_TYPE
-- 대여 가능한 2022-11-01 ~ 2022-12-01에 대여 기록이 없는 차량
WHERE car.CAR_ID NOT IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE END_DATE >= '2022-11-01' AND START_DATE <= '2022-12-01'
) AND plan.DURATION_TYPE like '30%'  -- 대여 기간이 30일 이상
GROUP BY car.CAR_ID
HAVING car.CAR_TYPE IN ('세단', 'SUV')  -- 자동차 종류가 세단과 SUV인 것만
AND FEE BETWEEN 500000 AND 2000000  -- 30일간의 대여 금액이 50만원 200만원 미만
ORDER BY
    FEE DESC,
    car.CAR_TYPE ASC,
    car.CAR_ID DESC;
