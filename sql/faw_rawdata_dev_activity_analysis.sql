CREATE TABLE activity_analysis
(
    campaign_name                      VARCHAR(255)   NOT NULL COMMENT '活动名称',
    campaign_id                        VARCHAR(255)   NOT NULL COMMENT '活动 ID',
    start_date                         DATETIME       NOT NULL COMMENT '开始时间',
    end_date                           DATETIME       NOT NULL COMMENT '结束时间',
    cost                               DECIMAL(16, 2) NOT NULL COMMENT '花费',
    monitor_rate                       DECIMAL(5, 2)  NOT NULL COMMENT '监控比率',
    exposure_count                     BIGINT         NOT NULL COMMENT '曝光次数',
    exposure_user_count                BIGINT         NOT NULL COMMENT '曝光人数',
    click_count                        BIGINT         NOT NULL COMMENT '点击次数',
    click_user_count                   BIGINT         NOT NULL COMMENT '点击人数',
    monthly_active_member_count        BIGINT         NOT NULL COMMENT '月活会员数',
    monthly_active_member_gmv          DECIMAL(16, 2) NOT NULL COMMENT '月活会员 GMV',
    new_member_acquisition_count       BIGINT         NOT NULL COMMENT '拉新会员数',
    new_member_acquisition_gmv         DECIMAL(16, 2) NOT NULL COMMENT '拉新会员 GMV',
    periodic_monthly_active_user_count BIGINT         NOT NULL COMMENT '周期月活人数',
    periodic_monthly_active_user_gmv   DECIMAL(16, 2) NOT NULL COMMENT '周期月活 GMV',
    periodic_new_member_count          BIGINT         NOT NULL COMMENT '周期新会员人数',
    periodic_new_member_gmv            DECIMAL(16, 2) NOT NULL COMMENT '周期新会员 GMV',
    next_month_active_member_count     BIGINT         NOT NULL COMMENT '*次月月活会员数',
    next_month_active_member_gmv       DECIMAL(16, 2) NOT NULL COMMENT '*次月月活会员GMV',
    next_month_new_member_count        BIGINT         NOT NULL COMMENT '*次月拉新会员数',
    next_month_new_member_gmv          DECIMAL(16, 2) NOT NULL COMMENT '*次月拉新会员GMV',
    activity_type                      VARCHAR(50)    NOT NULL COMMENT '活动类型'
);

INSERT INTO activity_analysis (campaign_name, campaign_id, start_date, end_date, cost, monitor_rate, exposure_count, exposure_user_count, click_count, click_user_count, monthly_active_member_count, monthly_active_member_gmv, new_member_acquisition_count, new_member_acquisition_gmv, periodic_monthly_active_user_count, periodic_monthly_active_user_gmv, periodic_new_member_count, periodic_new_member_gmv, next_month_active_member_count, next_month_active_member_gmv, next_month_new_member_count, next_month_new_member_gmv, activity_type) VALUES ('霸王茶姬_202502_214玫瑰水仙上新_霸王茶姬', '2446608', '2025-02-11 00:00:00', '2025-03-01 00:00:00', 2421009.00, 50.00, 106165580, 51379053, 16639300, 3178705, 574928, 26744367.00, 39347, 1442432.00, 16651794, 873562918.00, 2024570, 78241453.00, 123458, 987656.00, 23458, 654334.00, 'test2');
INSERT INTO activity_analysis (campaign_name, campaign_id, start_date, end_date, cost, monitor_rate, exposure_count, exposure_user_count, click_count, click_user_count, monthly_active_member_count, monthly_active_member_gmv, new_member_acquisition_count, new_member_acquisition_gmv, periodic_monthly_active_user_count, periodic_monthly_active_user_gmv, periodic_new_member_count, periodic_new_member_gmv, next_month_active_member_count, next_month_active_member_gmv, next_month_new_member_count, next_month_new_member_gmv, activity_type) VALUES ('霸王茶姬_202502_粉啵啵_霸王茶姬', '2447653', '2025-02-23 00:00:00', '2025-03-02 00:00:00', 3047485.00, 50.00, 50487633, 30239345, 8187901, 4975312, 240417, 11264934.00, 21332, 793091.00, 11867676, 588747934.00, 1284081, 48961285.00, 123459, 987657.00, 23459, 654335.00, 'test2');
INSERT INTO activity_analysis (campaign_name, campaign_id, start_date, end_date, cost, monitor_rate, exposure_count, exposure_user_count, click_count, click_user_count, monthly_active_member_count, monthly_active_member_gmv, new_member_acquisition_count, new_member_acquisition_gmv, periodic_monthly_active_user_count, periodic_monthly_active_user_gmv, periodic_new_member_count, periodic_new_member_gmv, next_month_active_member_count, next_month_active_member_gmv, next_month_new_member_count, next_month_new_member_gmv, activity_type) VALUES ('霸王茶姬_202502_开工第一杯_霸王茶姬', '2446171', '2025-02-04 00:00:00', '2025-02-12 00:00:00', 742704.00, 50.00, 35678545, 14653425, 5018633, 891591, 87605, 3999374.00, 6291, 229942.00, 13888409, 692387482.00, 1798012, 70009475.00, 123456, 987654.00, 23456, 654332.00, 'test1');
INSERT INTO activity_analysis (campaign_name, campaign_id, start_date, end_date, cost, monitor_rate, exposure_count, exposure_user_count, click_count, click_user_count, monthly_active_member_count, monthly_active_member_gmv, new_member_acquisition_count, new_member_acquisition_gmv, periodic_monthly_active_user_count, periodic_monthly_active_user_gmv, periodic_new_member_count, periodic_new_member_gmv, next_month_active_member_count, next_month_active_member_gmv, next_month_new_member_count, next_month_new_member_gmv, activity_type) VALUES ('霸王茶姬_202503_轻因茶上新_霸王茶姬', '2450234', '2025-03-18 00:00:00', '2025-03-27 00:00:00', 2307910.00, 50.00, 64428316, 33186079, 6719698, 2995634, 999999, 14788568.00, 99999, 1796374.00, 9999999, 22222222.00, 999999, 87537999.00, 123461, 987659.00, 23461, 654337.00, 'test2');
INSERT INTO activity_analysis (campaign_name, campaign_id, start_date, end_date, cost, monitor_rate, exposure_count, exposure_user_count, click_count, click_user_count, monthly_active_member_count, monthly_active_member_gmv, new_member_acquisition_count, new_member_acquisition_gmv, periodic_monthly_active_user_count, periodic_monthly_active_user_gmv, periodic_new_member_count, periodic_new_member_gmv, next_month_active_member_count, next_month_active_member_gmv, next_month_new_member_count, next_month_new_member_gmv, activity_type) VALUES ('霸王茶姬_202501_CNY活动_霸王茶姬', '2444958', '2025-01-21 00:00:00', '2025-02-11 00:00:00', 7455420.00, 50.00, 314250533, 88500318, 28953051, 7353321, 1163425, 60182080.00, 130765, 5185796.00, 23260836, 1370000000.00, 3891323, 166000000.00, 123457, 987655.00, 23457, 654333.00, 'test1');