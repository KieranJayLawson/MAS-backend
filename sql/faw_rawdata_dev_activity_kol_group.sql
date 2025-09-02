create table activity_kol_group
(
    campaign_name                  varchar(255)   not null comment '活动名称',
    kol_name                       varchar(255)   not null comment 'KOL名称',
    post_url                       varchar(255)   not null comment '发文链接',
    media                          varchar(255)   not null comment '媒介平台',
    post_date                      datetime       not null comment '发文日期',
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

INSERT INTO activity_kol_group (campaign_name, kol_name, post_url, media, post_date, cost, exposure_count, exposure_user_count, avg_impression_frequency, click_count, click_user_count, monthly_active_member_count, monthly_active_member_gmv, new_member_acquisition_count, new_member_acquisition_gmv, next_month_active_member_count, next_month_active_member_gmv, next_month_new_member_count, next_month_new_member_gmv) VALUES ('霸王茶姬_202502_214玫瑰水仙上新_霸王茶姬', '别再凶我辣', 'https://www.xiaohongshu.com/explore/67aeb5bf0000000018011e68?xsec_token=ABymAvWL-6X_i2_B37nNfz2wphCeL1D3iGgr3KH7Na1es=&xsec_source=pc_user', '小红书', '2025-02-01 00:00:00', 15676.23, 78903, 77346, 1.02, 16891, 16183, 200853, 15676.23, 31293, 15676.23, 31293, 15676.23, 31293, 15676.23);
INSERT INTO activity_kol_group (campaign_name, kol_name, post_url, media, post_date, cost, exposure_count, exposure_user_count, avg_impression_frequency, click_count, click_user_count, monthly_active_member_count, monthly_active_member_gmv, new_member_acquisition_count, new_member_acquisition_gmv, next_month_active_member_count, next_month_active_member_gmv, next_month_new_member_count, next_month_new_member_gmv) VALUES ('霸王茶姬_202502_214玫瑰水仙上新_霸王茶姬', '房灰灰', 'https://www.xiaohongshu.com/explore/67b1b82b000000002503c656?xsec_token=MB4ODg9RzZ0sHxqjtxgiuaTnB-FI0__snpF9JzmO8RPdQ=&xsec_source=pc_pgyexport', '小红书', '2025-02-02 00:00:00', 15676.23, 578842, 499075, 1.16, 70688, 67078, 161893, 15676.23, 31293, 15676.23, 31293, 15676.23, 31293, 15676.23);
INSERT INTO activity_kol_group (campaign_name, kol_name, post_url, media, post_date, cost, exposure_count, exposure_user_count, avg_impression_frequency, click_count, click_user_count, monthly_active_member_count, monthly_active_member_gmv, new_member_acquisition_count, new_member_acquisition_gmv, next_month_active_member_count, next_month_active_member_gmv, next_month_new_member_count, next_month_new_member_gmv) VALUES ('霸王茶姬_202502_214玫瑰水仙上新_霸王茶姬', '星子', 'https://www.xiaohongshu.com/explore/67b40647000000002602f52d?xsec_token=MBqy4HNxhms1DC0a6W42TKI1yGEMfnr9Jh8oMgKHrL7NI=&xsec_source=pc_pgyexport', '小红书', '2025-02-01 00:00:00', 15676.23, 28337, 28041, 1.01, 3577, 3411, 19974, 15676.23, 31293, 15676.23, 31293, 15676.23, 31293, 15676.23);
INSERT INTO activity_kol_group (campaign_name, kol_name, post_url, media, post_date, cost, exposure_count, exposure_user_count, avg_impression_frequency, click_count, click_user_count, monthly_active_member_count, monthly_active_member_gmv, new_member_acquisition_count, new_member_acquisition_gmv, next_month_active_member_count, next_month_active_member_gmv, next_month_new_member_count, next_month_new_member_gmv) VALUES ('霸王茶姬_202502_214玫瑰水仙上新_霸王茶姬', '沙琪玛', 'https://www.xiaohongshu.com/explore/67aead7800000000180066e8?xsec_token=ABymAvWL-6X_i2_B37nNfz2_v-RbMlg1yNFgazTWu-Hhc=&xsec_source=pc_user', '小红书', '2025-02-01 00:00:00', 15676.23, 45541, 44515, 1.02, 9551, 9196, 307020, 15676.23, 31293, 15676.23, 31293, 15676.23, 31293, 15676.23);
INSERT INTO activity_kol_group (campaign_name, kol_name, post_url, media, post_date, cost, exposure_count, exposure_user_count, avg_impression_frequency, click_count, click_user_count, monthly_active_member_count, monthly_active_member_gmv, new_member_acquisition_count, new_member_acquisition_gmv, next_month_active_member_count, next_month_active_member_gmv, next_month_new_member_count, next_month_new_member_gmv) VALUES ('霸王茶姬_202502_214玫瑰水仙上新_霸王茶姬', '牙牙爱手绘', 'https://www.xiaohongshu.com/explore/67ad4f540000000018019d63?xsec_token=MBPv2NtVcC-jGOLOzdmHKl3220j0xW1V-jpQZFmR_LDzk=&xsec_source=pc_pgyexport', '小红书', '2025-02-01 00:00:00', 15676.23, 735815, 525446, 1.40, 56831, 51286, 249038, 15676.23, 31293, 15676.23, 31293, 15676.23, 31293, 15676.23);