package cn.doublefloat.CDCSonCNN.framework.web.controller;

import cn.doublefloat.CDCSonCNN.common.constant.HttpStatus;
import cn.doublefloat.CDCSonCNN.common.utils.StringUtils;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import cn.doublefloat.CDCSonCNN.framework.web.page.PageDomain;
import cn.doublefloat.CDCSonCNN.framework.web.page.TableDataResult;
import cn.doublefloat.CDCSonCNN.framework.web.page.TableService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/7/19 4:21 下午
 */
@Slf4j
public class BaseController {

    protected void startPage() {
        PageDomain pageDomain = TableService.getPageDomain();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
            log.info("当前页" + pageNum);
            log.info("数据量" + pageSize);
            String orderColumn = pageDomain.getOrderColumn();
            PageHelper.startPage(pageNum, pageSize, orderColumn);
        }
    }

    protected TableDataResult getTableData(List<?> list) {
        TableDataResult tableDataResult = new TableDataResult();
        tableDataResult.setCode(HttpStatus.SUCCESS);
        tableDataResult.setMsg("查询成功!");
        tableDataResult.setRows(list);
        tableDataResult.setTotal(new PageInfo(list).getTotal());
        return tableDataResult;
    }

    protected AjaxResult toAjax(Integer row) {
        return row > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
