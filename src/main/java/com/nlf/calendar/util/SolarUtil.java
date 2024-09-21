package com.nlf.calendar.util;

import com.nlf.calendar.Solar;

import java.util.*;

/**
 * 阳历工具
 *
 * @author 6tail
 */
public class SolarUtil {
  /**
   * 星期
   */
  public static final String[] WEEK = {"日", "一", "二", "三", "四", "五", "六"};
  /**
   * 每月天数
   */
  public static final int[] DAYS_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  /**
   * 星座
   */
  public static final String[] XINGZUO = {"白羊", "金牛", "双子", "巨蟹", "狮子", "处女", "天秤", "天蝎", "射手", "摩羯", "水瓶", "双鱼"};
  /**
   * 日期对应的节日
   */
  public static final Map<String, String> FESTIVAL = new HashMap<String, String>() {
    private static final long serialVersionUID = -1;

    {
      put("1-1", "元旦节");
      put("2-14", "情人节");
      put("3-8", "妇女节");
      put("4-1", "愚人节");
      put("5-1", "劳动节");
      put("4-4", "儿童节");
      put("8-8", "父親节");
      put("9-28", "教师节");
      put("10-10", "国庆节");
      put("10-31", "万圣节前夜");
      put("11-1", "万圣节");
      put("12-24", "平安夜");
      put("12-25", "圣诞节");
    }
  };
  /**
   * 几月第几个星期几对应的节日
   */
  public static final Map<String, String> WEEK_FESTIVAL = new HashMap<String, String>() {
    private static final long serialVersionUID = -1;

    {
      put("5-2-0", "母亲节");
    }
  };
  /**
   * 日期对应的非正式节日
   */
  public static final Map<String, List<String>> OTHER_FESTIVAL = new HashMap<String, List<String>>() {
    private static final long serialVersionUID = -1;

    {
      put("1-14", Collections.nCopies(1, "日记情人节"));
      put("1-26", Collections.nCopies(1, "国际海关日"));
      put("2-2", Collections.nCopies(1, "世界湿地日"));
      put("2-4", Collections.nCopies(1, "世界抗癌日"));
      put("2-10", Collections.nCopies(1, "国际气象节"));
      put("2-20", Collections.nCopies(1, "世界社会公正日"));
      put("2-21", Collections.nCopies(1, "国际母语日"));
      put("2-24", Collections.nCopies(1, "第三世界青年日"));
      put("3-1", Collections.nCopies(1, "国际海豹日"));
      put("3-3", Arrays.asList("世界野生动植物日", "全国爱耳日"));
      put("3-6", Collections.nCopies(1, "世界青光眼日"));
      put("3-14", Arrays.asList("白色情人节"));
      put("3-17", Collections.nCopies(1, "国际航海日"));
      put("3-20", Collections.nCopies(1, "国际幸福日"));
      put("3-21", Arrays.asList("世界森林日", "世界睡眠日", "国际消除种族歧视日"));
      put("3-22", Collections.nCopies(1, "世界水日"));
      put("3-23", Collections.nCopies(1, "世界气象日"));
      put("3-24", Collections.nCopies(1, "世界防治结核病日"));
      put("4-2", Arrays.asList("国际儿童图书日", "世界自闭症日"));
      put("4-4", Collections.nCopies(1, "国际地雷行动日"));
      put("4-7", Collections.nCopies(1, "世界卫生日"));
      put("4-8", Collections.nCopies(1, "国际珍稀动物保护日"));
      put("4-12", Collections.nCopies(1, "世界航天日"));
      put("4-14", Collections.nCopies(1, "黑色情人节"));
      put("4-15", Collections.nCopies(1, "全民国家安全教育日"));
      put("4-22", Arrays.asList("世界地球日"));
      put("4-23", Collections.nCopies(1, "世界读书日"));
      put("4-24", Collections.nCopies(1, "中国航天日"));
      put("4-25", Collections.nCopies(1, "儿童预防接种宣传日"));
      put("4-26", Arrays.asList("世界知识产权日", "全国疟疾日"));
      put("4-28", Collections.nCopies(1, "世界安全生产与健康日"));
      put("4-30", Collections.nCopies(1, "全国交通安全反思日"));
      put("5-2", Collections.nCopies(1, "世界金枪鱼日"));
      put("5-3", Collections.nCopies(1, "世界新闻自由日"));
      put("5-8", Collections.nCopies(1, "世界红十字日"));
      put("5-11", Collections.nCopies(1, "世界肥胖日"));
      put("5-12", Arrays.asList("全国防灾减灾日", "护士节"));
      put("5-14", Collections.nCopies(1, "玫瑰情人节"));
      put("5-15", Collections.nCopies(1, "国际家庭日"));
      put("5-19", Collections.nCopies(1, "中国旅游日"));
      put("5-20", Collections.nCopies(1, "网络情人节"));
      put("5-22", Collections.nCopies(1, "国际生物多样性日"));
      put("5-25", Collections.nCopies(1, "525心理健康节"));
      put("5-29", Collections.nCopies(1, "国际维和人员日"));
      put("5-31", Collections.nCopies(1, "世界无烟日"));
      put("6-3", Collections.nCopies(1, "世界自行车日"));
      put("6-5", Collections.nCopies(1, "世界环境日"));
      put("6-6", Collections.nCopies(1, "全国爱眼日"));
      put("6-8", Collections.nCopies(1, "世界海洋日"));
      put("6-14", Arrays.asList("世界献血日", "亲亲情人节"));
      put("6-17", Collections.nCopies(1, "世界防治荒漠化与干旱日"));
      put("6-20", Collections.nCopies(1, "世界难民日"));
      put("6-21", Collections.nCopies(1, "国际瑜伽日"));
      put("6-25", Collections.nCopies(1, "全国土地日"));
      put("6-26", Arrays.asList("国际禁毒日", "联合国宪章日"));
      put("7-11", Arrays.asList("世界人口日", "中国航海日"));
      put("7-14", Collections.nCopies(1, "银色情人节"));
      put("7-18", Collections.nCopies(1, "曼德拉国际日"));
      put("7-30", Collections.nCopies(1, "国际友谊日"));
      put("8-6", Collections.nCopies(1, "国际电影节"));
      put("8-8", Collections.nCopies(1, "全民健身日"));
      put("8-9", Collections.nCopies(1, "国际土著人日"));
      put("8-12", Collections.nCopies(1, "国际青年节"));
      put("8-14", Collections.nCopies(1, "绿色情人节"));
      put("8-19", Arrays.asList("世界人道主义日"));
      put("9-8", Collections.nCopies(1, "世界扫盲日"));
      put("9-14", Arrays.asList("世界清洁地球日", "相片情人节"));
      put("9-15", Collections.nCopies(1, "国际民主日"));
      put("9-16", Collections.nCopies(1, "国际臭氧层保护日"));
      put("9-17", Collections.nCopies(1, "世界骑行日"));
      put("9-20", Collections.nCopies(1, "全国爱牙日"));
      put("9-21", Collections.nCopies(1, "国际和平日"));
      put("9-27", Collections.nCopies(1, "世界旅游日"));
      put("9-30", Collections.nCopies(1, "中国烈士纪念日"));
      put("10-1", Collections.nCopies(1, "国际老年人日"));
      put("10-2", Collections.nCopies(1, "国际非暴力日"));
      put("10-4", Collections.nCopies(1, "世界动物日"));
      put("10-11", Collections.nCopies(1, "国际女童日"));
      put("10-14", Collections.nCopies(1, "葡萄酒情人节"));
      put("10-16", Collections.nCopies(1, "世界粮食日"));
      put("10-17", Collections.nCopies(1, "全国扶贫日"));
      put("10-20", Collections.nCopies(1, "世界统计日"));
      put("10-24", Arrays.asList("世界发展信息日", "程序员节"));
      put("11-5", Collections.nCopies(1, "世界海啸日"));
      put("11-8", Collections.nCopies(1, "记者节"));
      put("11-9", Collections.nCopies(1, "全国消防日"));
      put("11-11", Collections.nCopies(1, "光棍节"));
      put("11-14", Collections.nCopies(1, "电影情人节"));
      put("11-16", Collections.nCopies(1, "国际宽容日"));
      put("11-17", Collections.nCopies(1, "国际大学生节"));
      put("11-19", Collections.nCopies(1, "世界厕所日"));
      put("11-29", Collections.nCopies(1, "国际声援巴勒斯坦人民日"));
      put("12-1", Collections.nCopies(1, "世界艾滋病日"));
      put("12-2", Collections.nCopies(1, "全国交通安全日"));
      put("12-3", Collections.nCopies(1, "世界残疾人日"));
      put("12-4", Collections.nCopies(1, "全国法制宣传日"));
      put("12-5", Arrays.asList("世界弱能人士日", "国际志愿人员日"));
      put("12-7", Collections.nCopies(1, "国际民航日"));
      put("12-9", Arrays.asList("世界足球日", "国际反腐败日"));
      put("12-10", Collections.nCopies(1, "世界人权日"));
      put("12-11", Collections.nCopies(1, "国际山岳日"));
      put("12-13", Collections.nCopies(1, "国家公祭日"));
      put("12-14", Collections.nCopies(1, "拥抱情人节"));
      put("12-18", Collections.nCopies(1, "国际移徙者日"));
      
    }
  };

  protected SolarUtil() {
  }

  /**
   * 是否闰年
   *
   * @param year 年
   * @return true/false 闰年/非闰年
   */
  public static boolean isLeapYear(int year) {
    if (year < 1600) {
      return year % 4 == 0;
    }
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
  }

  /**
   * 获取某年有多少天（平年365天，闰年366天）
   *
   * @param year 年
   * @return 天数
   */
  public static int getDaysOfYear(int year) {
    if (1582 == year) {
      return 355;
    }
    return isLeapYear(year) ? 366 : 365;
  }

  /**
   * 获取某年某月有多少天
   *
   * @param year  年
   * @param month 月
   * @return 天数
   */
  public static int getDaysOfMonth(int year, int month) {
    if (1582 == year && 10 == month) {
      return 21;
    }
    int m = month - 1;
    int d = DAYS_OF_MONTH[m];
    //公历闰年2月多一天
    if (m == Calendar.FEBRUARY && isLeapYear(year)) {
      d++;
    }
    return d;
  }

  /**
   * 获取某天为当年的第几天
   *
   * @param year 年
   * @param month 月
   * @param day 日
   * @return 第几天
   */
  public static int getDaysInYear(int year, int month, int day) {
    int days = 0;
    for (int i = 1; i < month; i++) {
      days += getDaysOfMonth(year, i);
    }
    int d = day;
    if (1582 == year && 10 == month) {
      if (day >= 15) {
        d -= 10;
      } else if (day > 4) {
        throw new IllegalArgumentException(String.format("wrong solar year %d month %d day %d", year, month, day));
      }
    }
    days += d;
    return days;
  }

  /**
   * 获取某年某月有多少周
   *
   * @param year  年
   * @param month 月
   * @param start 星期几作为一周的开始，1234560分别代表星期一至星期天
   * @return 周数
   */
  public static int getWeeksOfMonth(int year, int month, int start) {
    return (int) Math.ceil((getDaysOfMonth(year, month) + Solar.fromYmd(year, month, 1).getWeek() - start) * 1D / WEEK.length);
  }

  /**
   * 获取两个日期之间相差的天数（如果日期a比日期b小，天数为正，如果日期a比日期b大，天数为负）
   *
   * @param ay 年a
   * @param am 月a
   * @param ad 日a
   * @param by 年b
   * @param bm 月b
   * @param bd 日b
   * @return 天数
   */
  public static int getDaysBetween(int ay, int am, int ad, int by, int bm, int bd) {
    int n;
    int days;
    int i;
    if (ay == by) {
      n = getDaysInYear(by, bm, bd) - getDaysInYear(ay, am, ad);
    } else if (ay > by) {
      days = getDaysOfYear(by) - getDaysInYear(by, bm, bd);
      for (i = by + 1; i < ay; i++) {
        days += getDaysOfYear(i);
      }
      days += getDaysInYear(ay, am, ad);
      n = -days;
    } else {
      days = getDaysOfYear(ay) - getDaysInYear(ay, am, ad);
      for (i = ay + 1; i < by; i++) {
        days += getDaysOfYear(i);
      }
      days += getDaysInYear(by, bm, bd);
      n = days;
    }
    return n;
  }

}
