package tdi.bootcamp.training.springweb.perpusspringweb.controller;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.Rak;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class ReportController {

    @GetMapping("/example")
    public void exampleReport(HttpServletResponse response) throws JRException, IOException {
        InputStream jasperStream = this.getClass().getResourceAsStream("/jasper/jaspertest.jasper");
        Map<String,Object> params = new HashMap<>();
        params.put("nama","Bambange Esekese");
        params.put("status",false);
        params.put("saldo", new BigDecimal(2000000));
        Rak rakBuku = new Rak("001","bleukamba",4);
        params.put("rakBuku",rakBuku);

        List<Rak> listRak = Arrays.asList(rakBuku, rakBuku, rakBuku);


        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,params,new JRBeanCollectionDataSource(listRak));
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition","inline;filename=example.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint,outStream);
    }


}