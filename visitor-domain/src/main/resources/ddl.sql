create table Site
(
    id           bigint auto_increment primary key,
    siteRootPath varchar(50)
);

create table SiteVisitorStatistic
(
    id               bigint auto_increment primary key,
    siteId           bigint         not null,
    periodType       varchar(30)    not null,
    standardDateTime datetime       null,
    visitorCount     decimal(10, 0) not null
);

CREATE INDEX idx_site_root_path ON Site(siteRootPath);
CREATE INDEX standard_datetime_idx_site_id ON SiteVisitorStatistic(standardDateTime, siteId);