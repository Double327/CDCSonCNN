package cn.doublefloat.CDCSonCNN.projects.iclass.controller;

import cn.doublefloat.CDCSonCNN.framework.web.controller.BaseController;
import cn.doublefloat.CDCSonCNN.framework.web.domain.AjaxResult;
import cn.doublefloat.CDCSonCNN.framework.web.page.TableDataResult;
import cn.doublefloat.CDCSonCNN.projects.iclass.domain.Iclass;
import cn.doublefloat.CDCSonCNN.projects.iclass.service.IclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/12/7 10:20 下午
 */
@RestController
@RequestMapping("/class")
public class IclassController extends BaseController {
    @Autowired
    private IclassService iclassService;

    /**
     * 查询【请填写功能名称】列表
     */
    @GetMapping("/list")
    public TableDataResult list(Iclass iclass) {
        startPage();
        List<Iclass> list = iclassService.selectIclassList(iclass);
        return getTableData(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @GetMapping("/export")
    public AjaxResult export(Iclass iclass) {
        return null;
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(iclassService.selectIclassById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PostMapping
    public AjaxResult add(@RequestBody Iclass iclass) {
        return toAjax(iclassService.insertIclass(iclass));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PutMapping
    public AjaxResult edit(@RequestBody Iclass iclass) {
        return toAjax(iclassService.updateIclass(iclass));
    }

    /**
     * 删除【请填写功能名称】
     */
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(iclassService.deleteIclassByIds(ids));
    }
}
