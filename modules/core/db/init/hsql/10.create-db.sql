-- begin LFM_WORK_ORDER_DATA
create table LFM_WORK_ORDER_DATA (
    ID varchar(36) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    --
    WORK_ORDER varchar(12) not null,
    GTIN varchar(14) not null,
    INFO varchar(255),
    MATERIALE varchar(50),
    SER_TYPE integer not null,
    --
    primary key (ID)
)^
-- end LFM_WORK_ORDER_DATA
