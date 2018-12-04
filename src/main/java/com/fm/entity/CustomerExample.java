package com.fm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CustomerExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andCustIdIsNull() {
            addCriterion("cust_id is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(Integer value) {
            addCriterion("cust_id =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(Integer value) {
            addCriterion("cust_id <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(Integer value) {
            addCriterion("cust_id >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_id >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(Integer value) {
            addCriterion("cust_id <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(Integer value) {
            addCriterion("cust_id <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<Integer> values) {
            addCriterion("cust_id in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<Integer> values) {
            addCriterion("cust_id not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(Integer value1, Integer value2) {
            addCriterion("cust_id between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_id not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustNickIsNull() {
            addCriterion("cust_nick is null");
            return (Criteria) this;
        }

        public Criteria andCustNickIsNotNull() {
            addCriterion("cust_nick is not null");
            return (Criteria) this;
        }

        public Criteria andCustNickEqualTo(String value) {
            addCriterion("cust_nick =", value, "custNick");
            return (Criteria) this;
        }

        public Criteria andCustNickNotEqualTo(String value) {
            addCriterion("cust_nick <>", value, "custNick");
            return (Criteria) this;
        }

        public Criteria andCustNickGreaterThan(String value) {
            addCriterion("cust_nick >", value, "custNick");
            return (Criteria) this;
        }

        public Criteria andCustNickGreaterThanOrEqualTo(String value) {
            addCriterion("cust_nick >=", value, "custNick");
            return (Criteria) this;
        }

        public Criteria andCustNickLessThan(String value) {
            addCriterion("cust_nick <", value, "custNick");
            return (Criteria) this;
        }

        public Criteria andCustNickLessThanOrEqualTo(String value) {
            addCriterion("cust_nick <=", value, "custNick");
            return (Criteria) this;
        }

        public Criteria andCustNickLike(String value) {
            addCriterion("cust_nick like", value, "custNick");
            return (Criteria) this;
        }

        public Criteria andCustNickNotLike(String value) {
            addCriterion("cust_nick not like", value, "custNick");
            return (Criteria) this;
        }

        public Criteria andCustNickIn(List<String> values) {
            addCriterion("cust_nick in", values, "custNick");
            return (Criteria) this;
        }

        public Criteria andCustNickNotIn(List<String> values) {
            addCriterion("cust_nick not in", values, "custNick");
            return (Criteria) this;
        }

        public Criteria andCustNickBetween(String value1, String value2) {
            addCriterion("cust_nick between", value1, value2, "custNick");
            return (Criteria) this;
        }

        public Criteria andCustNickNotBetween(String value1, String value2) {
            addCriterion("cust_nick not between", value1, value2, "custNick");
            return (Criteria) this;
        }

        public Criteria andCustPasswordIsNull() {
            addCriterion("cust_password is null");
            return (Criteria) this;
        }

        public Criteria andCustPasswordIsNotNull() {
            addCriterion("cust_password is not null");
            return (Criteria) this;
        }

        public Criteria andCustPasswordEqualTo(String value) {
            addCriterion("cust_password =", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordNotEqualTo(String value) {
            addCriterion("cust_password <>", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordGreaterThan(String value) {
            addCriterion("cust_password >", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("cust_password >=", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordLessThan(String value) {
            addCriterion("cust_password <", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordLessThanOrEqualTo(String value) {
            addCriterion("cust_password <=", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordLike(String value) {
            addCriterion("cust_password like", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordNotLike(String value) {
            addCriterion("cust_password not like", value, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordIn(List<String> values) {
            addCriterion("cust_password in", values, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordNotIn(List<String> values) {
            addCriterion("cust_password not in", values, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordBetween(String value1, String value2) {
            addCriterion("cust_password between", value1, value2, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustPasswordNotBetween(String value1, String value2) {
            addCriterion("cust_password not between", value1, value2, "custPassword");
            return (Criteria) this;
        }

        public Criteria andCustIntroIsNull() {
            addCriterion("cust_intro is null");
            return (Criteria) this;
        }

        public Criteria andCustIntroIsNotNull() {
            addCriterion("cust_intro is not null");
            return (Criteria) this;
        }

        public Criteria andCustIntroEqualTo(String value) {
            addCriterion("cust_intro =", value, "custIntro");
            return (Criteria) this;
        }

        public Criteria andCustIntroNotEqualTo(String value) {
            addCriterion("cust_intro <>", value, "custIntro");
            return (Criteria) this;
        }

        public Criteria andCustIntroGreaterThan(String value) {
            addCriterion("cust_intro >", value, "custIntro");
            return (Criteria) this;
        }

        public Criteria andCustIntroGreaterThanOrEqualTo(String value) {
            addCriterion("cust_intro >=", value, "custIntro");
            return (Criteria) this;
        }

        public Criteria andCustIntroLessThan(String value) {
            addCriterion("cust_intro <", value, "custIntro");
            return (Criteria) this;
        }

        public Criteria andCustIntroLessThanOrEqualTo(String value) {
            addCriterion("cust_intro <=", value, "custIntro");
            return (Criteria) this;
        }

        public Criteria andCustIntroLike(String value) {
            addCriterion("cust_intro like", value, "custIntro");
            return (Criteria) this;
        }

        public Criteria andCustIntroNotLike(String value) {
            addCriterion("cust_intro not like", value, "custIntro");
            return (Criteria) this;
        }

        public Criteria andCustIntroIn(List<String> values) {
            addCriterion("cust_intro in", values, "custIntro");
            return (Criteria) this;
        }

        public Criteria andCustIntroNotIn(List<String> values) {
            addCriterion("cust_intro not in", values, "custIntro");
            return (Criteria) this;
        }

        public Criteria andCustIntroBetween(String value1, String value2) {
            addCriterion("cust_intro between", value1, value2, "custIntro");
            return (Criteria) this;
        }

        public Criteria andCustIntroNotBetween(String value1, String value2) {
            addCriterion("cust_intro not between", value1, value2, "custIntro");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIsNull() {
            addCriterion("cust_phone is null");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIsNotNull() {
            addCriterion("cust_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCustPhoneEqualTo(String value) {
            addCriterion("cust_phone =", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotEqualTo(String value) {
            addCriterion("cust_phone <>", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneGreaterThan(String value) {
            addCriterion("cust_phone >", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("cust_phone >=", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLessThan(String value) {
            addCriterion("cust_phone <", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLessThanOrEqualTo(String value) {
            addCriterion("cust_phone <=", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLike(String value) {
            addCriterion("cust_phone like", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotLike(String value) {
            addCriterion("cust_phone not like", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIn(List<String> values) {
            addCriterion("cust_phone in", values, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotIn(List<String> values) {
            addCriterion("cust_phone not in", values, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneBetween(String value1, String value2) {
            addCriterion("cust_phone between", value1, value2, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotBetween(String value1, String value2) {
            addCriterion("cust_phone not between", value1, value2, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustCreditsIsNull() {
            addCriterion("cust_credits is null");
            return (Criteria) this;
        }

        public Criteria andCustCreditsIsNotNull() {
            addCriterion("cust_credits is not null");
            return (Criteria) this;
        }

        public Criteria andCustCreditsEqualTo(Integer value) {
            addCriterion("cust_credits =", value, "custCredits");
            return (Criteria) this;
        }

        public Criteria andCustCreditsNotEqualTo(Integer value) {
            addCriterion("cust_credits <>", value, "custCredits");
            return (Criteria) this;
        }

        public Criteria andCustCreditsGreaterThan(Integer value) {
            addCriterion("cust_credits >", value, "custCredits");
            return (Criteria) this;
        }

        public Criteria andCustCreditsGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_credits >=", value, "custCredits");
            return (Criteria) this;
        }

        public Criteria andCustCreditsLessThan(Integer value) {
            addCriterion("cust_credits <", value, "custCredits");
            return (Criteria) this;
        }

        public Criteria andCustCreditsLessThanOrEqualTo(Integer value) {
            addCriterion("cust_credits <=", value, "custCredits");
            return (Criteria) this;
        }

        public Criteria andCustCreditsIn(List<Integer> values) {
            addCriterion("cust_credits in", values, "custCredits");
            return (Criteria) this;
        }

        public Criteria andCustCreditsNotIn(List<Integer> values) {
            addCriterion("cust_credits not in", values, "custCredits");
            return (Criteria) this;
        }

        public Criteria andCustCreditsBetween(Integer value1, Integer value2) {
            addCriterion("cust_credits between", value1, value2, "custCredits");
            return (Criteria) this;
        }

        public Criteria andCustCreditsNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_credits not between", value1, value2, "custCredits");
            return (Criteria) this;
        }

        public Criteria andRangeExpIsNull() {
            addCriterion("range_exp is null");
            return (Criteria) this;
        }

        public Criteria andRangeExpIsNotNull() {
            addCriterion("range_exp is not null");
            return (Criteria) this;
        }

        public Criteria andRangeExpEqualTo(Integer value) {
            addCriterion("range_exp =", value, "rangeExp");
            return (Criteria) this;
        }

        public Criteria andRangeExpNotEqualTo(Integer value) {
            addCriterion("range_exp <>", value, "rangeExp");
            return (Criteria) this;
        }

        public Criteria andRangeExpGreaterThan(Integer value) {
            addCriterion("range_exp >", value, "rangeExp");
            return (Criteria) this;
        }

        public Criteria andRangeExpGreaterThanOrEqualTo(Integer value) {
            addCriterion("range_exp >=", value, "rangeExp");
            return (Criteria) this;
        }

        public Criteria andRangeExpLessThan(Integer value) {
            addCriterion("range_exp <", value, "rangeExp");
            return (Criteria) this;
        }

        public Criteria andRangeExpLessThanOrEqualTo(Integer value) {
            addCriterion("range_exp <=", value, "rangeExp");
            return (Criteria) this;
        }

        public Criteria andRangeExpIn(List<Integer> values) {
            addCriterion("range_exp in", values, "rangeExp");
            return (Criteria) this;
        }

        public Criteria andRangeExpNotIn(List<Integer> values) {
            addCriterion("range_exp not in", values, "rangeExp");
            return (Criteria) this;
        }

        public Criteria andRangeExpBetween(Integer value1, Integer value2) {
            addCriterion("range_exp between", value1, value2, "rangeExp");
            return (Criteria) this;
        }

        public Criteria andRangeExpNotBetween(Integer value1, Integer value2) {
            addCriterion("range_exp not between", value1, value2, "rangeExp");
            return (Criteria) this;
        }

        public Criteria andRangeLevelIsNull() {
            addCriterion("range_level is null");
            return (Criteria) this;
        }

        public Criteria andRangeLevelIsNotNull() {
            addCriterion("range_level is not null");
            return (Criteria) this;
        }

        public Criteria andRangeLevelEqualTo(Integer value) {
            addCriterion("range_level =", value, "rangeLevel");
            return (Criteria) this;
        }

        public Criteria andRangeLevelNotEqualTo(Integer value) {
            addCriterion("range_level <>", value, "rangeLevel");
            return (Criteria) this;
        }

        public Criteria andRangeLevelGreaterThan(Integer value) {
            addCriterion("range_level >", value, "rangeLevel");
            return (Criteria) this;
        }

        public Criteria andRangeLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("range_level >=", value, "rangeLevel");
            return (Criteria) this;
        }

        public Criteria andRangeLevelLessThan(Integer value) {
            addCriterion("range_level <", value, "rangeLevel");
            return (Criteria) this;
        }

        public Criteria andRangeLevelLessThanOrEqualTo(Integer value) {
            addCriterion("range_level <=", value, "rangeLevel");
            return (Criteria) this;
        }

        public Criteria andRangeLevelIn(List<Integer> values) {
            addCriterion("range_level in", values, "rangeLevel");
            return (Criteria) this;
        }

        public Criteria andRangeLevelNotIn(List<Integer> values) {
            addCriterion("range_level not in", values, "rangeLevel");
            return (Criteria) this;
        }

        public Criteria andRangeLevelBetween(Integer value1, Integer value2) {
            addCriterion("range_level between", value1, value2, "rangeLevel");
            return (Criteria) this;
        }

        public Criteria andRangeLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("range_level not between", value1, value2, "rangeLevel");
            return (Criteria) this;
        }

        public Criteria andCustStatusIsNull() {
            addCriterion("cust_status is null");
            return (Criteria) this;
        }

        public Criteria andCustStatusIsNotNull() {
            addCriterion("cust_status is not null");
            return (Criteria) this;
        }

        public Criteria andCustStatusEqualTo(Integer value) {
            addCriterion("cust_status =", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotEqualTo(Integer value) {
            addCriterion("cust_status <>", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusGreaterThan(Integer value) {
            addCriterion("cust_status >", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_status >=", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusLessThan(Integer value) {
            addCriterion("cust_status <", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusLessThanOrEqualTo(Integer value) {
            addCriterion("cust_status <=", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusIn(List<Integer> values) {
            addCriterion("cust_status in", values, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotIn(List<Integer> values) {
            addCriterion("cust_status not in", values, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusBetween(Integer value1, Integer value2) {
            addCriterion("cust_status between", value1, value2, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_status not between", value1, value2, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustProfileIsNull() {
            addCriterion("cust_profile is null");
            return (Criteria) this;
        }

        public Criteria andCustProfileIsNotNull() {
            addCriterion("cust_profile is not null");
            return (Criteria) this;
        }

        public Criteria andCustProfileEqualTo(String value) {
            addCriterion("cust_profile =", value, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileNotEqualTo(String value) {
            addCriterion("cust_profile <>", value, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileGreaterThan(String value) {
            addCriterion("cust_profile >", value, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileGreaterThanOrEqualTo(String value) {
            addCriterion("cust_profile >=", value, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileLessThan(String value) {
            addCriterion("cust_profile <", value, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileLessThanOrEqualTo(String value) {
            addCriterion("cust_profile <=", value, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileLike(String value) {
            addCriterion("cust_profile like", value, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileNotLike(String value) {
            addCriterion("cust_profile not like", value, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileIn(List<String> values) {
            addCriterion("cust_profile in", values, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileNotIn(List<String> values) {
            addCriterion("cust_profile not in", values, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileBetween(String value1, String value2) {
            addCriterion("cust_profile between", value1, value2, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustProfileNotBetween(String value1, String value2) {
            addCriterion("cust_profile not between", value1, value2, "custProfile");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("cust_name is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("cust_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("cust_name =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("cust_name <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("cust_name >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("cust_name >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("cust_name <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("cust_name <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("cust_name like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("cust_name not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("cust_name in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("cust_name not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("cust_name between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("cust_name not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustGenderIsNull() {
            addCriterion("cust_gender is null");
            return (Criteria) this;
        }

        public Criteria andCustGenderIsNotNull() {
            addCriterion("cust_gender is not null");
            return (Criteria) this;
        }

        public Criteria andCustGenderEqualTo(Integer value) {
            addCriterion("cust_gender =", value, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderNotEqualTo(Integer value) {
            addCriterion("cust_gender <>", value, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderGreaterThan(Integer value) {
            addCriterion("cust_gender >", value, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_gender >=", value, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderLessThan(Integer value) {
            addCriterion("cust_gender <", value, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderLessThanOrEqualTo(Integer value) {
            addCriterion("cust_gender <=", value, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderIn(List<Integer> values) {
            addCriterion("cust_gender in", values, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderNotIn(List<Integer> values) {
            addCriterion("cust_gender not in", values, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderBetween(Integer value1, Integer value2) {
            addCriterion("cust_gender between", value1, value2, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_gender not between", value1, value2, "custGender");
            return (Criteria) this;
        }

        public Criteria andCustAgeIsNull() {
            addCriterion("cust_age is null");
            return (Criteria) this;
        }

        public Criteria andCustAgeIsNotNull() {
            addCriterion("cust_age is not null");
            return (Criteria) this;
        }

        public Criteria andCustAgeEqualTo(Integer value) {
            addCriterion("cust_age =", value, "custAge");
            return (Criteria) this;
        }

        public Criteria andCustAgeNotEqualTo(Integer value) {
            addCriterion("cust_age <>", value, "custAge");
            return (Criteria) this;
        }

        public Criteria andCustAgeGreaterThan(Integer value) {
            addCriterion("cust_age >", value, "custAge");
            return (Criteria) this;
        }

        public Criteria andCustAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_age >=", value, "custAge");
            return (Criteria) this;
        }

        public Criteria andCustAgeLessThan(Integer value) {
            addCriterion("cust_age <", value, "custAge");
            return (Criteria) this;
        }

        public Criteria andCustAgeLessThanOrEqualTo(Integer value) {
            addCriterion("cust_age <=", value, "custAge");
            return (Criteria) this;
        }

        public Criteria andCustAgeIn(List<Integer> values) {
            addCriterion("cust_age in", values, "custAge");
            return (Criteria) this;
        }

        public Criteria andCustAgeNotIn(List<Integer> values) {
            addCriterion("cust_age not in", values, "custAge");
            return (Criteria) this;
        }

        public Criteria andCustAgeBetween(Integer value1, Integer value2) {
            addCriterion("cust_age between", value1, value2, "custAge");
            return (Criteria) this;
        }

        public Criteria andCustAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_age not between", value1, value2, "custAge");
            return (Criteria) this;
        }

        public Criteria andCustEmailIsNull() {
            addCriterion("cust_email is null");
            return (Criteria) this;
        }

        public Criteria andCustEmailIsNotNull() {
            addCriterion("cust_email is not null");
            return (Criteria) this;
        }

        public Criteria andCustEmailEqualTo(String value) {
            addCriterion("cust_email =", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotEqualTo(String value) {
            addCriterion("cust_email <>", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailGreaterThan(String value) {
            addCriterion("cust_email >", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailGreaterThanOrEqualTo(String value) {
            addCriterion("cust_email >=", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLessThan(String value) {
            addCriterion("cust_email <", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLessThanOrEqualTo(String value) {
            addCriterion("cust_email <=", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLike(String value) {
            addCriterion("cust_email like", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotLike(String value) {
            addCriterion("cust_email not like", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailIn(List<String> values) {
            addCriterion("cust_email in", values, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotIn(List<String> values) {
            addCriterion("cust_email not in", values, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailBetween(String value1, String value2) {
            addCriterion("cust_email between", value1, value2, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotBetween(String value1, String value2) {
            addCriterion("cust_email not between", value1, value2, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustProvinceIsNull() {
            addCriterion("cust_province is null");
            return (Criteria) this;
        }

        public Criteria andCustProvinceIsNotNull() {
            addCriterion("cust_province is not null");
            return (Criteria) this;
        }

        public Criteria andCustProvinceEqualTo(String value) {
            addCriterion("cust_province =", value, "custProvince");
            return (Criteria) this;
        }

        public Criteria andCustProvinceNotEqualTo(String value) {
            addCriterion("cust_province <>", value, "custProvince");
            return (Criteria) this;
        }

        public Criteria andCustProvinceGreaterThan(String value) {
            addCriterion("cust_province >", value, "custProvince");
            return (Criteria) this;
        }

        public Criteria andCustProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("cust_province >=", value, "custProvince");
            return (Criteria) this;
        }

        public Criteria andCustProvinceLessThan(String value) {
            addCriterion("cust_province <", value, "custProvince");
            return (Criteria) this;
        }

        public Criteria andCustProvinceLessThanOrEqualTo(String value) {
            addCriterion("cust_province <=", value, "custProvince");
            return (Criteria) this;
        }

        public Criteria andCustProvinceLike(String value) {
            addCriterion("cust_province like", value, "custProvince");
            return (Criteria) this;
        }

        public Criteria andCustProvinceNotLike(String value) {
            addCriterion("cust_province not like", value, "custProvince");
            return (Criteria) this;
        }

        public Criteria andCustProvinceIn(List<String> values) {
            addCriterion("cust_province in", values, "custProvince");
            return (Criteria) this;
        }

        public Criteria andCustProvinceNotIn(List<String> values) {
            addCriterion("cust_province not in", values, "custProvince");
            return (Criteria) this;
        }

        public Criteria andCustProvinceBetween(String value1, String value2) {
            addCriterion("cust_province between", value1, value2, "custProvince");
            return (Criteria) this;
        }

        public Criteria andCustProvinceNotBetween(String value1, String value2) {
            addCriterion("cust_province not between", value1, value2, "custProvince");
            return (Criteria) this;
        }

        public Criteria andCustCityIsNull() {
            addCriterion("cust_city is null");
            return (Criteria) this;
        }

        public Criteria andCustCityIsNotNull() {
            addCriterion("cust_city is not null");
            return (Criteria) this;
        }

        public Criteria andCustCityEqualTo(String value) {
            addCriterion("cust_city =", value, "custCity");
            return (Criteria) this;
        }

        public Criteria andCustCityNotEqualTo(String value) {
            addCriterion("cust_city <>", value, "custCity");
            return (Criteria) this;
        }

        public Criteria andCustCityGreaterThan(String value) {
            addCriterion("cust_city >", value, "custCity");
            return (Criteria) this;
        }

        public Criteria andCustCityGreaterThanOrEqualTo(String value) {
            addCriterion("cust_city >=", value, "custCity");
            return (Criteria) this;
        }

        public Criteria andCustCityLessThan(String value) {
            addCriterion("cust_city <", value, "custCity");
            return (Criteria) this;
        }

        public Criteria andCustCityLessThanOrEqualTo(String value) {
            addCriterion("cust_city <=", value, "custCity");
            return (Criteria) this;
        }

        public Criteria andCustCityLike(String value) {
            addCriterion("cust_city like", value, "custCity");
            return (Criteria) this;
        }

        public Criteria andCustCityNotLike(String value) {
            addCriterion("cust_city not like", value, "custCity");
            return (Criteria) this;
        }

        public Criteria andCustCityIn(List<String> values) {
            addCriterion("cust_city in", values, "custCity");
            return (Criteria) this;
        }

        public Criteria andCustCityNotIn(List<String> values) {
            addCriterion("cust_city not in", values, "custCity");
            return (Criteria) this;
        }

        public Criteria andCustCityBetween(String value1, String value2) {
            addCriterion("cust_city between", value1, value2, "custCity");
            return (Criteria) this;
        }

        public Criteria andCustCityNotBetween(String value1, String value2) {
            addCriterion("cust_city not between", value1, value2, "custCity");
            return (Criteria) this;
        }

        public Criteria andCustIsSignIsNull() {
            addCriterion("cust_is_sign is null");
            return (Criteria) this;
        }

        public Criteria andCustIsSignIsNotNull() {
            addCriterion("cust_is_sign is not null");
            return (Criteria) this;
        }

        public Criteria andCustIsSignEqualTo(Integer value) {
            addCriterion("cust_is_sign =", value, "custIsSign");
            return (Criteria) this;
        }

        public Criteria andCustIsSignNotEqualTo(Integer value) {
            addCriterion("cust_is_sign <>", value, "custIsSign");
            return (Criteria) this;
        }

        public Criteria andCustIsSignGreaterThan(Integer value) {
            addCriterion("cust_is_sign >", value, "custIsSign");
            return (Criteria) this;
        }

        public Criteria andCustIsSignGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_is_sign >=", value, "custIsSign");
            return (Criteria) this;
        }

        public Criteria andCustIsSignLessThan(Integer value) {
            addCriterion("cust_is_sign <", value, "custIsSign");
            return (Criteria) this;
        }

        public Criteria andCustIsSignLessThanOrEqualTo(Integer value) {
            addCriterion("cust_is_sign <=", value, "custIsSign");
            return (Criteria) this;
        }

        public Criteria andCustIsSignIn(List<Integer> values) {
            addCriterion("cust_is_sign in", values, "custIsSign");
            return (Criteria) this;
        }

        public Criteria andCustIsSignNotIn(List<Integer> values) {
            addCriterion("cust_is_sign not in", values, "custIsSign");
            return (Criteria) this;
        }

        public Criteria andCustIsSignBetween(Integer value1, Integer value2) {
            addCriterion("cust_is_sign between", value1, value2, "custIsSign");
            return (Criteria) this;
        }

        public Criteria andCustIsSignNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_is_sign not between", value1, value2, "custIsSign");
            return (Criteria) this;
        }

        public Criteria andCustCreatetimeIsNull() {
            addCriterion("cust_createtime is null");
            return (Criteria) this;
        }

        public Criteria andCustCreatetimeIsNotNull() {
            addCriterion("cust_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCustCreatetimeEqualTo(Date value) {
            addCriterion("cust_createtime =", value, "custCreatetime");
            return (Criteria) this;
        }

        public Criteria andCustCreatetimeNotEqualTo(Date value) {
            addCriterion("cust_createtime <>", value, "custCreatetime");
            return (Criteria) this;
        }

        public Criteria andCustCreatetimeGreaterThan(Date value) {
            addCriterion("cust_createtime >", value, "custCreatetime");
            return (Criteria) this;
        }

        public Criteria andCustCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cust_createtime >=", value, "custCreatetime");
            return (Criteria) this;
        }

        public Criteria andCustCreatetimeLessThan(Date value) {
            addCriterion("cust_createtime <", value, "custCreatetime");
            return (Criteria) this;
        }

        public Criteria andCustCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("cust_createtime <=", value, "custCreatetime");
            return (Criteria) this;
        }

        public Criteria andCustCreatetimeIn(List<Date> values) {
            addCriterion("cust_createtime in", values, "custCreatetime");
            return (Criteria) this;
        }

        public Criteria andCustCreatetimeNotIn(List<Date> values) {
            addCriterion("cust_createtime not in", values, "custCreatetime");
            return (Criteria) this;
        }

        public Criteria andCustCreatetimeBetween(Date value1, Date value2) {
            addCriterion("cust_createtime between", value1, value2, "custCreatetime");
            return (Criteria) this;
        }

        public Criteria andCustCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("cust_createtime not between", value1, value2, "custCreatetime");
            return (Criteria) this;
        }

        public Criteria andCustUpdateTimeIsNull() {
            addCriterion("cust_update_time is null");
            return (Criteria) this;
        }

        public Criteria andCustUpdateTimeIsNotNull() {
            addCriterion("cust_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andCustUpdateTimeEqualTo(Date value) {
            addCriterion("cust_update_time =", value, "custUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCustUpdateTimeNotEqualTo(Date value) {
            addCriterion("cust_update_time <>", value, "custUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCustUpdateTimeGreaterThan(Date value) {
            addCriterion("cust_update_time >", value, "custUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCustUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cust_update_time >=", value, "custUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCustUpdateTimeLessThan(Date value) {
            addCriterion("cust_update_time <", value, "custUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCustUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("cust_update_time <=", value, "custUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCustUpdateTimeIn(List<Date> values) {
            addCriterion("cust_update_time in", values, "custUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCustUpdateTimeNotIn(List<Date> values) {
            addCriterion("cust_update_time not in", values, "custUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCustUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("cust_update_time between", value1, value2, "custUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCustUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("cust_update_time not between", value1, value2, "custUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBlank1IsNull() {
            addCriterion("blank_1 is null");
            return (Criteria) this;
        }

        public Criteria andBlank1IsNotNull() {
            addCriterion("blank_1 is not null");
            return (Criteria) this;
        }

        public Criteria andBlank1EqualTo(String value) {
            addCriterion("blank_1 =", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1NotEqualTo(String value) {
            addCriterion("blank_1 <>", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1GreaterThan(String value) {
            addCriterion("blank_1 >", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1GreaterThanOrEqualTo(String value) {
            addCriterion("blank_1 >=", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1LessThan(String value) {
            addCriterion("blank_1 <", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1LessThanOrEqualTo(String value) {
            addCriterion("blank_1 <=", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1Like(String value) {
            addCriterion("blank_1 like", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1NotLike(String value) {
            addCriterion("blank_1 not like", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1In(List<String> values) {
            addCriterion("blank_1 in", values, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1NotIn(List<String> values) {
            addCriterion("blank_1 not in", values, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1Between(String value1, String value2) {
            addCriterion("blank_1 between", value1, value2, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1NotBetween(String value1, String value2) {
            addCriterion("blank_1 not between", value1, value2, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank2IsNull() {
            addCriterion("blank_2 is null");
            return (Criteria) this;
        }

        public Criteria andBlank2IsNotNull() {
            addCriterion("blank_2 is not null");
            return (Criteria) this;
        }

        public Criteria andBlank2EqualTo(String value) {
            addCriterion("blank_2 =", value, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2NotEqualTo(String value) {
            addCriterion("blank_2 <>", value, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2GreaterThan(String value) {
            addCriterion("blank_2 >", value, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2GreaterThanOrEqualTo(String value) {
            addCriterion("blank_2 >=", value, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2LessThan(String value) {
            addCriterion("blank_2 <", value, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2LessThanOrEqualTo(String value) {
            addCriterion("blank_2 <=", value, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2Like(String value) {
            addCriterion("blank_2 like", value, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2NotLike(String value) {
            addCriterion("blank_2 not like", value, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2In(List<String> values) {
            addCriterion("blank_2 in", values, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2NotIn(List<String> values) {
            addCriterion("blank_2 not in", values, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2Between(String value1, String value2) {
            addCriterion("blank_2 between", value1, value2, "blank2");
            return (Criteria) this;
        }

        public Criteria andBlank2NotBetween(String value1, String value2) {
            addCriterion("blank_2 not between", value1, value2, "blank2");
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