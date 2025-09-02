create table activity_platform_content_group
(
    campaign_name                  varchar(255)   not null comment '活动名称',
    media                          varchar(255)   not null comment '媒介平台',
    content_format                 varchar(255)   not null comment '内容形式',
    cost                           decimal(16, 2) not null comment '花费',
    exposure_count                 bigint         not null comment '曝光次数',
    exposure_user_count            bigint         not null comment '曝光人数',
    avg_impression_frequency       decimal(16, 2) not null comment '平均曝光频次',
    click_count                    bigint         not null comment '点击次数',
    click_user_count               bigint         not null comment '点击人数',
    monthly_active_member_count    bigint         not null comment '月活会员数',
    monthly_active_member_gmv      decimal(16, 2) not null comment '月活会员GMV',
    new_member_acquisition_count   bigint         not null comment '拉新会员数',
    new_member_acquisition_gmv     decimal(16, 2) not null comment '拉新会员GMV',
    next_month_active_member_count bigint         not null comment '*次月月活会员数',
    next_month_active_member_gmv   decimal(16, 2) not null comment '*次月月活会员GMV',
    next_month_new_member_count    bigint         not null comment '*次月拉新会员数',
    next_month_new_member_gmv      decimal(16, 2) not null comment '*次月拉新会员GMV'
);

INSERT INTO activity_platform_content_group (campaign_name, media, content_format, cost, exposure_count, exposure_user_count, avg_impression_frequency, click_count, click_user_count, monthly_active_member_count, monthly_active_member_gmv, new_member_acquisition_count, new_member_acquisition_gmv, next_month_active_member_count, next_month_active_member_gmv, next_month_new_member_count, next_month_new_member_gmv) VALUES ('霸王茶姬_202502_214玫瑰水仙上新_霸王茶姬', '小红书', '图文', 15676.23, 8538797, 4583311, 1.86, 967777, 767033, 200853, 15676.23, 31293, 15676.23, 31293, 15676.23, 31293, 15676.23);
INSERT INTO activity_platform_content_group (campaign_name, media, content_format, cost, exposure_count, exposure_user_count, avg_impression_frequency, click_count, click_user_count, monthly_active_member_count, monthly_active_member_gmv, new_member_acquisition_count, new_member_acquisition_gmv, next_month_active_member_count, next_month_active_member_gmv, next_month_new_member_count, next_month_new_member_gmv) VALUES ('霸王茶姬_202502_214玫瑰水仙上新_霸王茶姬', '小红书', '视频', 15676.23, 8234549, 5201994, 1.58, 1351410, 1092422, 307020, 15676.23, 31293, 15676.23, 31293, 15676.23, 31293, 15676.23);
INSERT INTO activity_platform_content_group (campaign_name, media, content_format, cost, exposure_count, exposure_user_count, avg_impression_frequency, click_count, click_user_count, monthly_active_member_count, monthly_active_member_gmv, new_member_acquisition_count, new_member_acquisition_gmv, next_month_active_member_count, next_month_active_member_gmv, next_month_new_member_count, next_month_new_member_gmv) VALUES ('霸王茶姬_202502_214玫瑰水仙上新_霸王茶姬', '抖音', '视频', 15676.23, 14270187, 9665886, 1.48, 2319187, 1822785, 63176, 15676.23, 31293, 15676.23, 31293, 15676.23, 31293, 15676.23);