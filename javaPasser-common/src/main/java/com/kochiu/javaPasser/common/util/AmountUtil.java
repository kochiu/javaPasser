package com.kochiu.javaPasser.common.util;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: gaochao
 * Date: 2016/5/18.
 * Time: 11:36.
 */
public class AmountUtil {

    private BigDecimal value;

    /**
     * 提供默认精度10
     */
    private static final int scale = 10;

    /**
     * 金额为分的格式
     */
    public static final String CURRENCY_FEN_REGEX = "\\-?[0-9]+";

    /**
     * 将分为单位的转换为元并返回金额格式的字符串 （除100）
     *
     * @param amount
     * @return
     * @throws Exception
     */
    public static String changeF2Y(Long amount) throws Exception {
        if (!amount.toString().matches(CURRENCY_FEN_REGEX)) {
            throw new Exception("金额格式有误");
        }

        int flag = 0;
        String amString = amount.toString();
        if (amString.charAt(0) == '-') {
            flag = 1;
            amString = amString.substring(1);
        }
        StringBuffer result = new StringBuffer();
        if (amString.length() == 1) {
            result.append("0.0").append(amString);
        } else if (amString.length() == 2) {
            result.append("0.").append(amString);
        } else {
            String intString = amString.substring(0, amString.length() - 2);
            for (int i = 1; i <= intString.length(); i++) {
                if ((i - 1) % 3 == 0 && i != 1) {
                    result.append(",");
                }
                result.append(intString.substring(intString.length() - i, intString.length() - i + 1));
            }
            result.reverse().append(".").append(amString.substring(amString.length() - 2));
        }
        if (flag == 1) {
            return "-" + result.toString();
        } else {
            return result.toString();
        }
    }

    /**
     * 将分为单位的转换为元 （除100）
     *
     * @param amount
     * @return
     * @throws Exception
     */
    public static String changeF2Y(String amount) throws Exception {
        if (!amount.matches(CURRENCY_FEN_REGEX)) {
            throw new Exception("金额格式有误");
        }
        return BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100)).toString();
    }

    /**
     * 将元为单位的转换为分 （乘100）
     *
     * @param amount
     * @return
     */
    public static String changeY2F(Long amount) {
        return BigDecimal.valueOf(amount).multiply(new BigDecimal(100)).toString();
    }

    /**
     * 将元为单位的转换为分 替换小数点，支持以逗号区分的金额
     *
     * @param amount
     * @return
     */
    public static String changeY2F(String amount) {
        String currency = amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额
        int index = currency.indexOf(".");
        int length = currency.length();
        Long amLong = 0l;
        if (index == -1) {
            amLong = Long.valueOf(currency + "00");
        } else if (length - index >= 3) {
            amLong = Long.valueOf((currency.substring(0, index + 3)).replace(".", ""));
        } else if (length - index == 2) {
            amLong = Long.valueOf((currency.substring(0, index + 2)).replace(".", "") + 0);
        } else {
            amLong = Long.valueOf((currency.substring(0, index + 1)).replace(".", "") + "00");
        }
        return amLong.toString();
    }


    /**
     * double类型构造函数
     *
     * @param value
     */
    public AmountUtil(double value) {
        this.value = new BigDecimal(Double.toString(value));
    }

    /**
     * String类型构造函数
     *
     * @param value
     */
    public AmountUtil(String value) {
        this.value = new BigDecimal(value);
    }

    /**
     * 取得BigDecimal的值
     *
     * @return
     */
    public BigDecimal getValue() {
        return this.value;
    }

    /**
     * 两个double类型的数值相加
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double add(double v1, double v2) {
        AmountUtil a1 = new AmountUtil(v1);
        AmountUtil a2 = new AmountUtil(v2);
        return add(a1, a2);
    }

    /**
     * 两数相除
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double div(double v1, double v2) {
        AmountUtil a1 = new AmountUtil(v1);
        AmountUtil a2 = new AmountUtil(v2);
        return divide(a1, a2);
    }

    /**
     * 相减
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double sub(double v1, double v2) {
        AmountUtil a1 = new AmountUtil(v1);
        AmountUtil a2 = new AmountUtil(v2);
        return subtract(a1, a2);
    }

    /**
     * 相乘
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double mul(double v1, double v2) {
        AmountUtil a1 = new AmountUtil(v1);
        AmountUtil a2 = new AmountUtil(v2);
        return multiply(a1, a2);
    }

    /**
     * 两个Amount类型的数据进行相加
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double add(AmountUtil v1, AmountUtil v2) {
        return v1.getValue().add(v2.getValue()).doubleValue();
    }

    /**
     * 两个Amount类型变量相除
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double divide(AmountUtil v1, AmountUtil v2) {
        if (scale < 0) {
            throw new IllegalArgumentException("精度指定错误,请指定一个>=0的精度");
        }
        return v1.getValue().divide(v2.getValue(), scale,
                BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 两数相乘
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double multiply(AmountUtil v1, AmountUtil v2) {
        return v1.getValue().multiply(v2.getValue()).doubleValue();
    }

    /**
     * 两数相减
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double subtract(AmountUtil v1, AmountUtil v2) {
        return v1.getValue().subtract(v2.getValue()).doubleValue();
    }


    public static void main(String[] args) {
        System.out.println(String.valueOf(add(0.15,0.01)));
    }
}
