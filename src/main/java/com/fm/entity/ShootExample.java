package com.fm.entity;

import java.util.ArrayList;
import java.util.List;

public class ShootExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShootExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andShootIdIsNull() {
            addCriterion("shoot_id is null");
            return (Criteria) this;
        }

        public Criteria andShootIdIsNotNull() {
            addCriterion("shoot_id is not null");
            return (Criteria) this;
        }

        public Criteria andShootIdEqualTo(Integer value) {
            addCriterion("shoot_id =", value, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdNotEqualTo(Integer value) {
            addCriterion("shoot_id <>", value, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdGreaterThan(Integer value) {
            addCriterion("shoot_id >", value, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shoot_id >=", value, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdLessThan(Integer value) {
            addCriterion("shoot_id <", value, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdLessThanOrEqualTo(Integer value) {
            addCriterion("shoot_id <=", value, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdIn(List<Integer> values) {
            addCriterion("shoot_id in", values, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdNotIn(List<Integer> values) {
            addCriterion("shoot_id not in", values, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdBetween(Integer value1, Integer value2) {
            addCriterion("shoot_id between", value1, value2, "shootId");
            return (Criteria) this;
        }

        public Criteria andShootIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shoot_id not between", value1, value2, "shootId");
            return (Criteria) this;
        }

        public Criteria andThemeIdIsNull() {
            addCriterion("theme_id is null");
            return (Criteria) this;
        }

        public Criteria andThemeIdIsNotNull() {
            addCriterion("theme_id is not null");
            return (Criteria) this;
        }

        public Criteria andThemeIdEqualTo(Integer value) {
            addCriterion("theme_id =", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdNotEqualTo(Integer value) {
            addCriterion("theme_id <>", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdGreaterThan(Integer value) {
            addCriterion("theme_id >", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("theme_id >=", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdLessThan(Integer value) {
            addCriterion("theme_id <", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdLessThanOrEqualTo(Integer value) {
            addCriterion("theme_id <=", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdIn(List<Integer> values) {
            addCriterion("theme_id in", values, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdNotIn(List<Integer> values) {
            addCriterion("theme_id not in", values, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdBetween(Integer value1, Integer value2) {
            addCriterion("theme_id between", value1, value2, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("theme_id not between", value1, value2, "themeId");
            return (Criteria) this;
        }

        public Criteria andShootDescIsNull() {
            addCriterion("shoot_desc is null");
            return (Criteria) this;
        }

        public Criteria andShootDescIsNotNull() {
            addCriterion("shoot_desc is not null");
            return (Criteria) this;
        }

        public Criteria andShootDescEqualTo(String value) {
            addCriterion("shoot_desc =", value, "shootDesc");
            return (Criteria) this;
        }

        public Criteria andShootDescNotEqualTo(String value) {
            addCriterion("shoot_desc <>", value, "shootDesc");
            return (Criteria) this;
        }

        public Criteria andShootDescGreaterThan(String value) {
            addCriterion("shoot_desc >", value, "shootDesc");
            return (Criteria) this;
        }

        public Criteria andShootDescGreaterThanOrEqualTo(String value) {
            addCriterion("shoot_desc >=", value, "shootDesc");
            return (Criteria) this;
        }

        public Criteria andShootDescLessThan(String value) {
            addCriterion("shoot_desc <", value, "shootDesc");
            return (Criteria) this;
        }

        public Criteria andShootDescLessThanOrEqualTo(String value) {
            addCriterion("shoot_desc <=", value, "shootDesc");
            return (Criteria) this;
        }

        public Criteria andShootDescLike(String value) {
            addCriterion("shoot_desc like", value, "shootDesc");
            return (Criteria) this;
        }

        public Criteria andShootDescNotLike(String value) {
            addCriterion("shoot_desc not like", value, "shootDesc");
            return (Criteria) this;
        }

        public Criteria andShootDescIn(List<String> values) {
            addCriterion("shoot_desc in", values, "shootDesc");
            return (Criteria) this;
        }

        public Criteria andShootDescNotIn(List<String> values) {
            addCriterion("shoot_desc not in", values, "shootDesc");
            return (Criteria) this;
        }

        public Criteria andShootDescBetween(String value1, String value2) {
            addCriterion("shoot_desc between", value1, value2, "shootDesc");
            return (Criteria) this;
        }

        public Criteria andShootDescNotBetween(String value1, String value2) {
            addCriterion("shoot_desc not between", value1, value2, "shootDesc");
            return (Criteria) this;
        }

        public Criteria andShootPriceIsNull() {
            addCriterion("shoot_price is null");
            return (Criteria) this;
        }

        public Criteria andShootPriceIsNotNull() {
            addCriterion("shoot_price is not null");
            return (Criteria) this;
        }

        public Criteria andShootPriceEqualTo(Double value) {
            addCriterion("shoot_price =", value, "shootPrice");
            return (Criteria) this;
        }

        public Criteria andShootPriceNotEqualTo(Double value) {
            addCriterion("shoot_price <>", value, "shootPrice");
            return (Criteria) this;
        }

        public Criteria andShootPriceGreaterThan(Double value) {
            addCriterion("shoot_price >", value, "shootPrice");
            return (Criteria) this;
        }

        public Criteria andShootPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("shoot_price >=", value, "shootPrice");
            return (Criteria) this;
        }

        public Criteria andShootPriceLessThan(Double value) {
            addCriterion("shoot_price <", value, "shootPrice");
            return (Criteria) this;
        }

        public Criteria andShootPriceLessThanOrEqualTo(Double value) {
            addCriterion("shoot_price <=", value, "shootPrice");
            return (Criteria) this;
        }

        public Criteria andShootPriceIn(List<Double> values) {
            addCriterion("shoot_price in", values, "shootPrice");
            return (Criteria) this;
        }

        public Criteria andShootPriceNotIn(List<Double> values) {
            addCriterion("shoot_price not in", values, "shootPrice");
            return (Criteria) this;
        }

        public Criteria andShootPriceBetween(Double value1, Double value2) {
            addCriterion("shoot_price between", value1, value2, "shootPrice");
            return (Criteria) this;
        }

        public Criteria andShootPriceNotBetween(Double value1, Double value2) {
            addCriterion("shoot_price not between", value1, value2, "shootPrice");
            return (Criteria) this;
        }

        public Criteria andShootStatusIsNull() {
            addCriterion("shoot_status is null");
            return (Criteria) this;
        }

        public Criteria andShootStatusIsNotNull() {
            addCriterion("shoot_status is not null");
            return (Criteria) this;
        }

        public Criteria andShootStatusEqualTo(Integer value) {
            addCriterion("shoot_status =", value, "shootStatus");
            return (Criteria) this;
        }

        public Criteria andShootStatusNotEqualTo(Integer value) {
            addCriterion("shoot_status <>", value, "shootStatus");
            return (Criteria) this;
        }

        public Criteria andShootStatusGreaterThan(Integer value) {
            addCriterion("shoot_status >", value, "shootStatus");
            return (Criteria) this;
        }

        public Criteria andShootStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("shoot_status >=", value, "shootStatus");
            return (Criteria) this;
        }

        public Criteria andShootStatusLessThan(Integer value) {
            addCriterion("shoot_status <", value, "shootStatus");
            return (Criteria) this;
        }

        public Criteria andShootStatusLessThanOrEqualTo(Integer value) {
            addCriterion("shoot_status <=", value, "shootStatus");
            return (Criteria) this;
        }

        public Criteria andShootStatusIn(List<Integer> values) {
            addCriterion("shoot_status in", values, "shootStatus");
            return (Criteria) this;
        }

        public Criteria andShootStatusNotIn(List<Integer> values) {
            addCriterion("shoot_status not in", values, "shootStatus");
            return (Criteria) this;
        }

        public Criteria andShootStatusBetween(Integer value1, Integer value2) {
            addCriterion("shoot_status between", value1, value2, "shootStatus");
            return (Criteria) this;
        }

        public Criteria andShootStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("shoot_status not between", value1, value2, "shootStatus");
            return (Criteria) this;
        }

        public Criteria andShootLocIsNull() {
            addCriterion("shoot_loc is null");
            return (Criteria) this;
        }

        public Criteria andShootLocIsNotNull() {
            addCriterion("shoot_loc is not null");
            return (Criteria) this;
        }

        public Criteria andShootLocEqualTo(String value) {
            addCriterion("shoot_loc =", value, "shootLoc");
            return (Criteria) this;
        }

        public Criteria andShootLocNotEqualTo(String value) {
            addCriterion("shoot_loc <>", value, "shootLoc");
            return (Criteria) this;
        }

        public Criteria andShootLocGreaterThan(String value) {
            addCriterion("shoot_loc >", value, "shootLoc");
            return (Criteria) this;
        }

        public Criteria andShootLocGreaterThanOrEqualTo(String value) {
            addCriterion("shoot_loc >=", value, "shootLoc");
            return (Criteria) this;
        }

        public Criteria andShootLocLessThan(String value) {
            addCriterion("shoot_loc <", value, "shootLoc");
            return (Criteria) this;
        }

        public Criteria andShootLocLessThanOrEqualTo(String value) {
            addCriterion("shoot_loc <=", value, "shootLoc");
            return (Criteria) this;
        }

        public Criteria andShootLocLike(String value) {
            addCriterion("shoot_loc like", value, "shootLoc");
            return (Criteria) this;
        }

        public Criteria andShootLocNotLike(String value) {
            addCriterion("shoot_loc not like", value, "shootLoc");
            return (Criteria) this;
        }

        public Criteria andShootLocIn(List<String> values) {
            addCriterion("shoot_loc in", values, "shootLoc");
            return (Criteria) this;
        }

        public Criteria andShootLocNotIn(List<String> values) {
            addCriterion("shoot_loc not in", values, "shootLoc");
            return (Criteria) this;
        }

        public Criteria andShootLocBetween(String value1, String value2) {
            addCriterion("shoot_loc between", value1, value2, "shootLoc");
            return (Criteria) this;
        }

        public Criteria andShootLocNotBetween(String value1, String value2) {
            addCriterion("shoot_loc not between", value1, value2, "shootLoc");
            return (Criteria) this;
        }

        public Criteria andImg1PathIsNull() {
            addCriterion("img1_path is null");
            return (Criteria) this;
        }

        public Criteria andImg1PathIsNotNull() {
            addCriterion("img1_path is not null");
            return (Criteria) this;
        }

        public Criteria andImg1PathEqualTo(String value) {
            addCriterion("img1_path =", value, "img1Path");
            return (Criteria) this;
        }

        public Criteria andImg1PathNotEqualTo(String value) {
            addCriterion("img1_path <>", value, "img1Path");
            return (Criteria) this;
        }

        public Criteria andImg1PathGreaterThan(String value) {
            addCriterion("img1_path >", value, "img1Path");
            return (Criteria) this;
        }

        public Criteria andImg1PathGreaterThanOrEqualTo(String value) {
            addCriterion("img1_path >=", value, "img1Path");
            return (Criteria) this;
        }

        public Criteria andImg1PathLessThan(String value) {
            addCriterion("img1_path <", value, "img1Path");
            return (Criteria) this;
        }

        public Criteria andImg1PathLessThanOrEqualTo(String value) {
            addCriterion("img1_path <=", value, "img1Path");
            return (Criteria) this;
        }

        public Criteria andImg1PathLike(String value) {
            addCriterion("img1_path like", value, "img1Path");
            return (Criteria) this;
        }

        public Criteria andImg1PathNotLike(String value) {
            addCriterion("img1_path not like", value, "img1Path");
            return (Criteria) this;
        }

        public Criteria andImg1PathIn(List<String> values) {
            addCriterion("img1_path in", values, "img1Path");
            return (Criteria) this;
        }

        public Criteria andImg1PathNotIn(List<String> values) {
            addCriterion("img1_path not in", values, "img1Path");
            return (Criteria) this;
        }

        public Criteria andImg1PathBetween(String value1, String value2) {
            addCriterion("img1_path between", value1, value2, "img1Path");
            return (Criteria) this;
        }

        public Criteria andImg1PathNotBetween(String value1, String value2) {
            addCriterion("img1_path not between", value1, value2, "img1Path");
            return (Criteria) this;
        }

        public Criteria andImg2PathIsNull() {
            addCriterion("img2_path is null");
            return (Criteria) this;
        }

        public Criteria andImg2PathIsNotNull() {
            addCriterion("img2_path is not null");
            return (Criteria) this;
        }

        public Criteria andImg2PathEqualTo(String value) {
            addCriterion("img2_path =", value, "img2Path");
            return (Criteria) this;
        }

        public Criteria andImg2PathNotEqualTo(String value) {
            addCriterion("img2_path <>", value, "img2Path");
            return (Criteria) this;
        }

        public Criteria andImg2PathGreaterThan(String value) {
            addCriterion("img2_path >", value, "img2Path");
            return (Criteria) this;
        }

        public Criteria andImg2PathGreaterThanOrEqualTo(String value) {
            addCriterion("img2_path >=", value, "img2Path");
            return (Criteria) this;
        }

        public Criteria andImg2PathLessThan(String value) {
            addCriterion("img2_path <", value, "img2Path");
            return (Criteria) this;
        }

        public Criteria andImg2PathLessThanOrEqualTo(String value) {
            addCriterion("img2_path <=", value, "img2Path");
            return (Criteria) this;
        }

        public Criteria andImg2PathLike(String value) {
            addCriterion("img2_path like", value, "img2Path");
            return (Criteria) this;
        }

        public Criteria andImg2PathNotLike(String value) {
            addCriterion("img2_path not like", value, "img2Path");
            return (Criteria) this;
        }

        public Criteria andImg2PathIn(List<String> values) {
            addCriterion("img2_path in", values, "img2Path");
            return (Criteria) this;
        }

        public Criteria andImg2PathNotIn(List<String> values) {
            addCriterion("img2_path not in", values, "img2Path");
            return (Criteria) this;
        }

        public Criteria andImg2PathBetween(String value1, String value2) {
            addCriterion("img2_path between", value1, value2, "img2Path");
            return (Criteria) this;
        }

        public Criteria andImg2PathNotBetween(String value1, String value2) {
            addCriterion("img2_path not between", value1, value2, "img2Path");
            return (Criteria) this;
        }

        public Criteria andImg3PathIsNull() {
            addCriterion("img3_path is null");
            return (Criteria) this;
        }

        public Criteria andImg3PathIsNotNull() {
            addCriterion("img3_path is not null");
            return (Criteria) this;
        }

        public Criteria andImg3PathEqualTo(String value) {
            addCriterion("img3_path =", value, "img3Path");
            return (Criteria) this;
        }

        public Criteria andImg3PathNotEqualTo(String value) {
            addCriterion("img3_path <>", value, "img3Path");
            return (Criteria) this;
        }

        public Criteria andImg3PathGreaterThan(String value) {
            addCriterion("img3_path >", value, "img3Path");
            return (Criteria) this;
        }

        public Criteria andImg3PathGreaterThanOrEqualTo(String value) {
            addCriterion("img3_path >=", value, "img3Path");
            return (Criteria) this;
        }

        public Criteria andImg3PathLessThan(String value) {
            addCriterion("img3_path <", value, "img3Path");
            return (Criteria) this;
        }

        public Criteria andImg3PathLessThanOrEqualTo(String value) {
            addCriterion("img3_path <=", value, "img3Path");
            return (Criteria) this;
        }

        public Criteria andImg3PathLike(String value) {
            addCriterion("img3_path like", value, "img3Path");
            return (Criteria) this;
        }

        public Criteria andImg3PathNotLike(String value) {
            addCriterion("img3_path not like", value, "img3Path");
            return (Criteria) this;
        }

        public Criteria andImg3PathIn(List<String> values) {
            addCriterion("img3_path in", values, "img3Path");
            return (Criteria) this;
        }

        public Criteria andImg3PathNotIn(List<String> values) {
            addCriterion("img3_path not in", values, "img3Path");
            return (Criteria) this;
        }

        public Criteria andImg3PathBetween(String value1, String value2) {
            addCriterion("img3_path between", value1, value2, "img3Path");
            return (Criteria) this;
        }

        public Criteria andImg3PathNotBetween(String value1, String value2) {
            addCriterion("img3_path not between", value1, value2, "img3Path");
            return (Criteria) this;
        }

        public Criteria andImg4PathIsNull() {
            addCriterion("img4_path is null");
            return (Criteria) this;
        }

        public Criteria andImg4PathIsNotNull() {
            addCriterion("img4_path is not null");
            return (Criteria) this;
        }

        public Criteria andImg4PathEqualTo(String value) {
            addCriterion("img4_path =", value, "img4Path");
            return (Criteria) this;
        }

        public Criteria andImg4PathNotEqualTo(String value) {
            addCriterion("img4_path <>", value, "img4Path");
            return (Criteria) this;
        }

        public Criteria andImg4PathGreaterThan(String value) {
            addCriterion("img4_path >", value, "img4Path");
            return (Criteria) this;
        }

        public Criteria andImg4PathGreaterThanOrEqualTo(String value) {
            addCriterion("img4_path >=", value, "img4Path");
            return (Criteria) this;
        }

        public Criteria andImg4PathLessThan(String value) {
            addCriterion("img4_path <", value, "img4Path");
            return (Criteria) this;
        }

        public Criteria andImg4PathLessThanOrEqualTo(String value) {
            addCriterion("img4_path <=", value, "img4Path");
            return (Criteria) this;
        }

        public Criteria andImg4PathLike(String value) {
            addCriterion("img4_path like", value, "img4Path");
            return (Criteria) this;
        }

        public Criteria andImg4PathNotLike(String value) {
            addCriterion("img4_path not like", value, "img4Path");
            return (Criteria) this;
        }

        public Criteria andImg4PathIn(List<String> values) {
            addCriterion("img4_path in", values, "img4Path");
            return (Criteria) this;
        }

        public Criteria andImg4PathNotIn(List<String> values) {
            addCriterion("img4_path not in", values, "img4Path");
            return (Criteria) this;
        }

        public Criteria andImg4PathBetween(String value1, String value2) {
            addCriterion("img4_path between", value1, value2, "img4Path");
            return (Criteria) this;
        }

        public Criteria andImg4PathNotBetween(String value1, String value2) {
            addCriterion("img4_path not between", value1, value2, "img4Path");
            return (Criteria) this;
        }

        public Criteria andImg5PathIsNull() {
            addCriterion("img5_path is null");
            return (Criteria) this;
        }

        public Criteria andImg5PathIsNotNull() {
            addCriterion("img5_path is not null");
            return (Criteria) this;
        }

        public Criteria andImg5PathEqualTo(String value) {
            addCriterion("img5_path =", value, "img5Path");
            return (Criteria) this;
        }

        public Criteria andImg5PathNotEqualTo(String value) {
            addCriterion("img5_path <>", value, "img5Path");
            return (Criteria) this;
        }

        public Criteria andImg5PathGreaterThan(String value) {
            addCriterion("img5_path >", value, "img5Path");
            return (Criteria) this;
        }

        public Criteria andImg5PathGreaterThanOrEqualTo(String value) {
            addCriterion("img5_path >=", value, "img5Path");
            return (Criteria) this;
        }

        public Criteria andImg5PathLessThan(String value) {
            addCriterion("img5_path <", value, "img5Path");
            return (Criteria) this;
        }

        public Criteria andImg5PathLessThanOrEqualTo(String value) {
            addCriterion("img5_path <=", value, "img5Path");
            return (Criteria) this;
        }

        public Criteria andImg5PathLike(String value) {
            addCriterion("img5_path like", value, "img5Path");
            return (Criteria) this;
        }

        public Criteria andImg5PathNotLike(String value) {
            addCriterion("img5_path not like", value, "img5Path");
            return (Criteria) this;
        }

        public Criteria andImg5PathIn(List<String> values) {
            addCriterion("img5_path in", values, "img5Path");
            return (Criteria) this;
        }

        public Criteria andImg5PathNotIn(List<String> values) {
            addCriterion("img5_path not in", values, "img5Path");
            return (Criteria) this;
        }

        public Criteria andImg5PathBetween(String value1, String value2) {
            addCriterion("img5_path between", value1, value2, "img5Path");
            return (Criteria) this;
        }

        public Criteria andImg5PathNotBetween(String value1, String value2) {
            addCriterion("img5_path not between", value1, value2, "img5Path");
            return (Criteria) this;
        }

        public Criteria andImg6PathIsNull() {
            addCriterion("img6_path is null");
            return (Criteria) this;
        }

        public Criteria andImg6PathIsNotNull() {
            addCriterion("img6_path is not null");
            return (Criteria) this;
        }

        public Criteria andImg6PathEqualTo(String value) {
            addCriterion("img6_path =", value, "img6Path");
            return (Criteria) this;
        }

        public Criteria andImg6PathNotEqualTo(String value) {
            addCriterion("img6_path <>", value, "img6Path");
            return (Criteria) this;
        }

        public Criteria andImg6PathGreaterThan(String value) {
            addCriterion("img6_path >", value, "img6Path");
            return (Criteria) this;
        }

        public Criteria andImg6PathGreaterThanOrEqualTo(String value) {
            addCriterion("img6_path >=", value, "img6Path");
            return (Criteria) this;
        }

        public Criteria andImg6PathLessThan(String value) {
            addCriterion("img6_path <", value, "img6Path");
            return (Criteria) this;
        }

        public Criteria andImg6PathLessThanOrEqualTo(String value) {
            addCriterion("img6_path <=", value, "img6Path");
            return (Criteria) this;
        }

        public Criteria andImg6PathLike(String value) {
            addCriterion("img6_path like", value, "img6Path");
            return (Criteria) this;
        }

        public Criteria andImg6PathNotLike(String value) {
            addCriterion("img6_path not like", value, "img6Path");
            return (Criteria) this;
        }

        public Criteria andImg6PathIn(List<String> values) {
            addCriterion("img6_path in", values, "img6Path");
            return (Criteria) this;
        }

        public Criteria andImg6PathNotIn(List<String> values) {
            addCriterion("img6_path not in", values, "img6Path");
            return (Criteria) this;
        }

        public Criteria andImg6PathBetween(String value1, String value2) {
            addCriterion("img6_path between", value1, value2, "img6Path");
            return (Criteria) this;
        }

        public Criteria andImg6PathNotBetween(String value1, String value2) {
            addCriterion("img6_path not between", value1, value2, "img6Path");
            return (Criteria) this;
        }

        public Criteria andImg7PathIsNull() {
            addCriterion("img7_path is null");
            return (Criteria) this;
        }

        public Criteria andImg7PathIsNotNull() {
            addCriterion("img7_path is not null");
            return (Criteria) this;
        }

        public Criteria andImg7PathEqualTo(String value) {
            addCriterion("img7_path =", value, "img7Path");
            return (Criteria) this;
        }

        public Criteria andImg7PathNotEqualTo(String value) {
            addCriterion("img7_path <>", value, "img7Path");
            return (Criteria) this;
        }

        public Criteria andImg7PathGreaterThan(String value) {
            addCriterion("img7_path >", value, "img7Path");
            return (Criteria) this;
        }

        public Criteria andImg7PathGreaterThanOrEqualTo(String value) {
            addCriterion("img7_path >=", value, "img7Path");
            return (Criteria) this;
        }

        public Criteria andImg7PathLessThan(String value) {
            addCriterion("img7_path <", value, "img7Path");
            return (Criteria) this;
        }

        public Criteria andImg7PathLessThanOrEqualTo(String value) {
            addCriterion("img7_path <=", value, "img7Path");
            return (Criteria) this;
        }

        public Criteria andImg7PathLike(String value) {
            addCriterion("img7_path like", value, "img7Path");
            return (Criteria) this;
        }

        public Criteria andImg7PathNotLike(String value) {
            addCriterion("img7_path not like", value, "img7Path");
            return (Criteria) this;
        }

        public Criteria andImg7PathIn(List<String> values) {
            addCriterion("img7_path in", values, "img7Path");
            return (Criteria) this;
        }

        public Criteria andImg7PathNotIn(List<String> values) {
            addCriterion("img7_path not in", values, "img7Path");
            return (Criteria) this;
        }

        public Criteria andImg7PathBetween(String value1, String value2) {
            addCriterion("img7_path between", value1, value2, "img7Path");
            return (Criteria) this;
        }

        public Criteria andImg7PathNotBetween(String value1, String value2) {
            addCriterion("img7_path not between", value1, value2, "img7Path");
            return (Criteria) this;
        }

        public Criteria andImg8PathIsNull() {
            addCriterion("img8_path is null");
            return (Criteria) this;
        }

        public Criteria andImg8PathIsNotNull() {
            addCriterion("img8_path is not null");
            return (Criteria) this;
        }

        public Criteria andImg8PathEqualTo(String value) {
            addCriterion("img8_path =", value, "img8Path");
            return (Criteria) this;
        }

        public Criteria andImg8PathNotEqualTo(String value) {
            addCriterion("img8_path <>", value, "img8Path");
            return (Criteria) this;
        }

        public Criteria andImg8PathGreaterThan(String value) {
            addCriterion("img8_path >", value, "img8Path");
            return (Criteria) this;
        }

        public Criteria andImg8PathGreaterThanOrEqualTo(String value) {
            addCriterion("img8_path >=", value, "img8Path");
            return (Criteria) this;
        }

        public Criteria andImg8PathLessThan(String value) {
            addCriterion("img8_path <", value, "img8Path");
            return (Criteria) this;
        }

        public Criteria andImg8PathLessThanOrEqualTo(String value) {
            addCriterion("img8_path <=", value, "img8Path");
            return (Criteria) this;
        }

        public Criteria andImg8PathLike(String value) {
            addCriterion("img8_path like", value, "img8Path");
            return (Criteria) this;
        }

        public Criteria andImg8PathNotLike(String value) {
            addCriterion("img8_path not like", value, "img8Path");
            return (Criteria) this;
        }

        public Criteria andImg8PathIn(List<String> values) {
            addCriterion("img8_path in", values, "img8Path");
            return (Criteria) this;
        }

        public Criteria andImg8PathNotIn(List<String> values) {
            addCriterion("img8_path not in", values, "img8Path");
            return (Criteria) this;
        }

        public Criteria andImg8PathBetween(String value1, String value2) {
            addCriterion("img8_path between", value1, value2, "img8Path");
            return (Criteria) this;
        }

        public Criteria andImg8PathNotBetween(String value1, String value2) {
            addCriterion("img8_path not between", value1, value2, "img8Path");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}