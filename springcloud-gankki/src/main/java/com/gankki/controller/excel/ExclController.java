package com.gankki.controller.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/excel")
@Slf4j
public class ExclController {

    @RequestMapping("/test")
    public String testAop(@RequestParam("file") MultipartFile file) throws Exception {
        EasyExcel.read(file.getInputStream(), new NoModelDataListener()).sheet().headRowNumber(0).doRead();
        return "Success";
    }

    public class NoModelDataListener extends AnalysisEventListener<Map<Byte, String>> {
        private static final int BATCH_COUNT = 100;
        private List<Map<Byte, String>> cachedDataList = Lists.newArrayList();


        @Override
        public void invoke(Map<Byte, String> data, AnalysisContext context) {
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
            log.info("数据解析完成！");
        }
    }


}
