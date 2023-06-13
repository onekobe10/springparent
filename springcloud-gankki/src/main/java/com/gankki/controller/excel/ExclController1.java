package com.gankki.controller.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.util.*;

@RestController
@RequestMapping("/excel1")
@Slf4j
public class ExclController1 {

    @RequestMapping("/test")
    public String testAop(@RequestParam("file") MultipartFile file) throws Exception {
        EasyExcel.read(file.getInputStream(), new NoModelDataListener()).sheet().headRowNumber(1).doRead();
        return "Success";
    }

    public static void main(String[] args) {
        Field[] fields = TestClass1.class.getClass().getFields();	// 获取对象的所有属性
        for (Field item : fields) {
            String name = item.getName();	// 获取对象属性名
            String typeName = item.getType().getTypeName();	// 获取对象属性的类型
            System.out.printf("属性名：%s,类型：%s\n", name, typeName);
        }
    }

    public class NoModelDataListener extends AnalysisEventListener<Map<Integer, String>> {
        private static final int BATCH_COUNT = 100;
        private List<Map<Integer, String>> cachedDataList = Lists.newArrayList();


        @Override
        public void invoke(Map<Integer, String> data, AnalysisContext context) {
            //excel的行号
            Integer rowIndex = context.readRowHolder().getRowIndex();
            Set set = data.keySet();
            for (Object next : set) {
                System.out.println("key==" + next + "value==" + data.get(next) + "rowIndex:" + rowIndex);
            }
            cachedDataList.add(data);

            // 获取总行数（含表头）
            Integer rowNumber = context.readSheetHolder().getApproximateTotalRowNumber();
            System.out.println("excel总行数==" + rowNumber);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            // 保存数据
            log.info("数据解析完成！");
        }
    }


}
