package com.nlf.calendar.util;

import com.nlf.calendar.Holiday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 法定节假日工具（自2011年1月1日起）
 *
 * @author 6tail
 */
public class HolidayUtil {

  /** 数据段长度 */
  private static final int SIZE = 18;
  /** 0 */
  private static final char ZERO = '0';
  /** 节假日名称（元旦0，春节1，清明2，劳动3，端午4，中秋5，国庆6，国庆中秋7，抗战胜利日8） */
  private static final String[] NAMES = {"元旦节","春节","清明节","劳动节","端午节","中秋节","国庆节","国庆中秋","抗战胜利日"};
  /** 节假日数据，日期YYYYMMDD+名称下标+是否调休+对应节日YYYYMMDD */
  private static final String DATA = "201101010120110101201101020120110101201101030120110101201101301020110203201102021120110203201102031120110203201102041120110203201102051120110203201102061120110203201102071120110203201102081120110203201102121020110203201104022020110405201104032120110405201104042120110405201104052120110405201104303120110501201105013120110501201105023120110501201106044120110606201106054120110606201106064120110606201109105120110912201109115120110912201109125120110912201110016120111001201110026120111001201110036120111001201110046120111001201110056120111001201110066120111001201110076120111001201110086020111001201110096020111001201112310020120101201201010120120101201201020120120101201201030120120101201201211020120123201201221120120123201201231120120123201201241120120123201201251120120123201201261120120123201201271120120123201201281120120123201201291020120123201203312020120404201204012020120404201204022120120404201204032120120404201204042120120404201204283020120501201204293120120501201204303120120501201205013120120501201205023020120501201206224120120623201206234120120623201206244120120623201209295020120930201209305120120930201210016120121001201210026120121001201210036120121001201210046120121001201210056120121001201210066120121001201210076120121001201210086020121001201301010120130101201301020120130101201301030120130101201301050020130101201301060020130101201302091120130210201302101120130210201302111120130210201302121120130210201302131120130210201302141120130210201302151120130210201302161020130210201302171020130210201304042120130404201304052120130404201304062120130404201304273020130501201304283020130501201304293120130501201304303120130501201305013120130501201306084020130612201306094020130612201306104120130612201306114120130612201306124120130612201309195120130919201309205120130919201309215120130919201309225020130919201309296020131001201310016120131001201310026120131001201310036120131001201310046120131001201310056120131001201310066120131001201310076120131001201401010120140101201401261020140131201401311120140131201402011120140131201402021120140131201402031120140131201402041120140131201402051120140131201402061120140131201402081020140131201404052120140405201404062120140405201404072120140405201405013120140501201405023120140501201405033120140501201405043020140501201405314120140602201406014120140602201406024120140602201409065120140908201409075120140908201409085120140908201409286020141001201410016120141001201410026120141001201410036120141001201410046120141004201410056120141001201410066120141001201410076120141001201410116020141001201501010120150101201501020120150101201501030120150101201501040020150101201502151020150219201502181120150219201502191120150219201502201120150219201502211120150219201502221120150219201502231120150219201502241120150219201502281020150219201504042120150405201504052120150405201504062120150405201505013120150501201505023120150501201505033120150501201506204120150620201506214120150620201506224120150620201509038120150903201509048120150903201509058120150903201509068020150903201509265120150927201509275120150927201510016120151001201510026120151001201510036120151001201510046120151004201510056120151001201510066120151001201510076120151001201510106020151001201601010120160101201601020120160101201601030120160101201602061020160208201602071120160208201602081120160208201602091120160208201602101120160208201602111120160208201602121120160208201602131120160208201602141020160208201604022120160404201604032120160404201604042120160404201604303120160501201605013120160501201605023120160501201606094120160609201606104120160609201606114120160609201606124020160609201609155120160915201609165120160915201609175120160915201609185020160915201610016120161001201610026120161001201610036120161001201610046120161004201610056120161001201610066120161001201610076120161001201610086020161001201610096020161001201612310120170101201701010120170101201701020120170101201701221020170128201701271120170128201701281120170128201701291120170128201701301120170128201701311120170128201702011120170128201702021120170128201702041020170128201704012020170404201704022120170404201704032120170404201704042120170404201704293120170501201704303120170501201705013120170501201705274020170530201705284120170530201705294120170530201705304120170530201709306020171001201710016120171001201710026120171001201710036120171001201710045120171004201710056120171001201710066120171001201710076120171001201710086120171001201712300120180101201712310120180101201801010120180101201802111020180216201802151120180216201802161120180216201802171120180216201802181120180216201802191120180216201802201120180216201802211120180216201802241020180216201804052120180405201804062120180405201804072120180405201804082020180405201804283020180501201804293120180501201804303120180501201805013120180501201806164120180618201806174120180618201806184120180618201809225120180924201809235120180924201809245120180924201809296020181001201809306020181001201810016120181001201810026120181001201810036120181001201810046120181001201810056120181001201810066120181001201810076120181001201812290020190101201812300120190101201812310120190101201901010120190101201902021020190205201902031020190205201902041120190205201902051120190205201902061120190205201902071120190205201902081120190205201902091120190205201902101120190205201904052120190405201904062120190405201904072120190405201904283020190501201905013120190501201905023120190501201905033120190501201905043120190501201905053020190501201906074120190607201906084120190607201906094120190607201909135120190913201909145120190913201909155120190913201909296020191001201910016120191001201910026120191001201910036120191001201910046120191001201910056120191001201910066120191001201910076120191001201910126020191001202001010120200101202001191020200125202001241120200125202001251120200125202001261120200125202001271120200125202001281120200125202001291120200125202001301120200125202001311120200125202002011120200125202002021120200125202004042120200404202004052120200404202004062120200404202004263020200501202005013120200501202005023120200501202005033120200501202005043120200501202005053120200501202005093020200501202006254120200625202006264120200625202006274120200625202006284020200625202009277020201001202010017120201001202010026120201001202010036120201001202010046120201001202010056120201001202010066120201001202010076120201001202010086120201001202010106020201001";

  private HolidayUtil(){}

  private static String padding(int n){
    return (n<10?"0":"")+n;
  }

  private static Holiday buildHolidayForward(String s){
    String day = s.substring(0,8);
    String name = NAMES[s.charAt(8)-ZERO];
    boolean work = s.charAt(9)==ZERO;
    String target = s.substring(10,SIZE);
    return new Holiday(day,name,work,target);
  }

  private static Holiday buildHolidayBackward(String s){
    int size = s.length();
    String day = s.substring(size-18,size-10);
    String name = NAMES[s.charAt(size-10)-ZERO];
    boolean work = s.charAt(size-9)==ZERO;
    String target = s.substring(size-8);
    return new Holiday(day,name,work,target);
  }

  private static String findForward(String key){
    int start = DATA.indexOf(key);
    if(start<0) {
      return null;
    }
    String right = DATA.substring(start);
    int n = right.length()%SIZE;
    if(n>0){
      right = right.substring(n);
    }
    while((!right.startsWith(key))&&right.length()>=SIZE){
      right = right.substring(SIZE);
    }
    return right;
  }

  private static String findBackward(String key){
    int start = DATA.lastIndexOf(key);
    if(start<0) {
      return null;
    }
    String left = DATA.substring(0,start+key.length());
    int size = left.length();
    int n = size%SIZE;
    if(n>0){
      left = left.substring(0,size-n);
    }
    size = left.length();
    while((!left.endsWith(key))&&size>=SIZE){
      left = left.substring(0,size-SIZE);
      size = left.length();
    }
    return left;
  }

  private static List<Holiday> findHolidaysForward(String key){
    List<Holiday> l = new ArrayList<Holiday>();
    String s = findForward(key);
    if(null==s) {
      return l;
    }
    while(s.startsWith(key)){
      l.add(buildHolidayForward(s));
      s = s.substring(SIZE);
    }
    return l;
  }

  private static List<Holiday> findHolidaysBackward(String key){
    List<Holiday> l = new ArrayList<Holiday>();
    String s = findBackward(key);
    if(null==s) {
      return l;
    }
    while(s.endsWith(key)){
      l.add(buildHolidayBackward(s));
      s = s.substring(0,s.length()-SIZE);
    }
    Collections.reverse(l);
    return l;
  }

  /**
   * 获取指定年月日的节假日信息，如果不存在，返回null
   * @param year 年
   * @param month 月，1-12
   * @param day 日，1-31
   * @return 节假日
   */
  public static Holiday getHoliday(int year,int month, int day){
    List<Holiday> l = findHolidaysForward(year+padding(month)+padding(day));
    return l.isEmpty()?null:l.get(0);
  }

  /**
   * 获取指定年月日的节假日信息，如果不存在，返回null
   * @param ymd 年月日
   * @return 节假日
   */
  public static Holiday getHoliday(String ymd){
    List<Holiday> l = findHolidaysForward(ymd.replace("-",""));
    return l.isEmpty()?null:l.get(0);
  }

  /**
   * 获取指定年月的节假日列表
   * @param year 年
   * @param month 月，1-12
   * @return 节假日列表
   */
  public static List<Holiday> getHolidays(int year, int month){
    return findHolidaysForward(year+padding(month));
  }

  /**
   * 获取指定年的节假日列表
   * @param year 年
   * @return 节假日列表
   */
  public static List<Holiday> getHolidays(int year){
    return findHolidaysForward(year+"");
  }

  /**
   * 获取指定年月日的节假日列表
   * @param ymd 年、年月、年月日
   * @return 节假日列表
   */
  public static List<Holiday> getHolidays(String ymd){
    return findHolidaysForward(ymd.replace("-",""));
  }

  /**
   * 获取指定节日（仅节日当天）的相关节假日列表
   * @param ymd 年月日
   * @return 节假日列表
   */
  public static List<Holiday> getHolidaysByTarget(String ymd){
    return findHolidaysBackward(ymd.replace("-",""));
  }

  /**
   * 获取指定节日（仅节日当天）的相关节假日列表
   * @param year 年
   * @param month 月
   * @param day 日
   * @return 节假日列表
   */
  public static List<Holiday> getHolidaysByTarget(int year,int month, int day){
    return findHolidaysBackward(year+padding(month)+padding(day));
  }
}
