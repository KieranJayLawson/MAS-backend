package com.hy.exceltemp;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactTypeCompositionExcel {
    @ExcelProperty("活动ID")
    private String cid;
    @ExcelProperty("活动名称")
    private String cname;
    @ExcelProperty("媒介")
    private String media;
    @ExcelProperty("触点类型")
    @ColumnWidth(25)
    private String contactPoint;
    @ExcelProperty("指标")
    private String field;
}
