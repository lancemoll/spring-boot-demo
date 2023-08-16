package com.xkcoding.orm.mybatis.plus.util;

import cn.hutool.core.util.ObjectUtil;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.stream.Collectors;

public class ParseJdHtmlUtil {
    public static final String url = "https://www.gov.hk/tc/about/abouthk/holiday/2023.htm";

    @SneakyThrows
    public static void parseByKeyword(){
        Document document = Jsoup.parse(new URL(url), 40000);
        Element tableContext = document.getElementsByClass("blockItem").first();
        Element table = tableContext.getElementsByTag("table").first();
        Elements elements = table.getElementsByTag("tr");
        elements.stream().skip(1).filter(item -> item.getElementsByClass("desc") != null)
            .forEach(item -> {
            String desc = item.getElementsByClass("desc").get(0).text();
            String date = item.getElementsByClass("date").get(0).text();
            String weekday = item.getElementsByClass("weekday").get(0).text();
            System.out.println("日期："+ date + "，desc: "+ desc + "，星期：" + weekday);

        });
    }

    public static void main(String[] args) {
        parseByKeyword();
    }

}
