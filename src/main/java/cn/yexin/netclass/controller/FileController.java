package cn.yexin.netclass.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.yexin.netclass.pojo.Courseware;
import cn.yexin.netclass.pojo.Homework;
import cn.yexin.netclass.service.CoursewareService;
import cn.yexin.netclass.service.HomeworkService;

@RequestMapping("/file")
@Controller
public class FileController {

    @Resource
    private CoursewareService coursewareService;
    @Resource
    private HomeworkService homeworkService;

    //教师上传课件
    @RequestMapping(value = "/upload.do")
    @ResponseBody
    public String upload(MultipartFile file, HttpServletRequest request, String teacherName, String courseName, String wareDescribe)
            throws IOException {
        // String path =
        // request.getSession().getServletContext().getRealPath("..\\upload");
        String path = "C:\\upload";
        String fileName = file.getOriginalFilename();
        path = path + "\\" + teacherName + "\\" + courseName;
        File dir = new File(path, fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // MultipartFile自带的解析方法
        file.transferTo(dir);
        //System.out.println(path);
        //System.out.println(fileName);

        String msg = coursewareService.uploadCourseware(fileName, wareDescribe, teacherName, courseName);
        return msg;
    }

    @RequestMapping(value = "/loadFiles.do")
    @ResponseBody
    public List<Courseware> listFiles(String teacherName, String courseName) {
        // 读取upload文件夹下有哪些文件可以下载
        // String path = this.getServletContext().getRealPath("/upload");
        // 遍历这个file中的内容,也就是文件
        // String path =
        // request.getSession().getServletContext().getRealPath("..\\upload")+"\\"+teacherName+"\\"+courseName;
//        String path = "D:\\upload" + "\\" + teacherName + "\\" + courseName;
//        Map<String, String> filesMap = new HashMap<String, String>();
//        File file = new File(path);
//        listfile(file, filesMap);
        // request.setAttribute("list", list);
        // System.out.println(filesMap);
//        Iterator<Map.Entry<String, String>> it = filesMap.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry<String, String> entry = it.next();
//            System.out.println("文件名:" + entry.getKey() + "\t绝对路径:" + entry.getValue());
//        }
        List<Courseware> list = coursewareService.listCourseware(teacherName, courseName);
        return list;
        // request.getRequestDispatcher("/download.jsp").forward(request, response);
    }

    public void listfile(File file, Map<String, String> map) {
        if (file.isFile()) {
            map.put(file.getName(), file.getAbsolutePath());
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                listfile(f, map);
            }
        }
    }


    @RequestMapping("/down.do")
    public void down(HttpServletRequest request, HttpServletResponse response, String filePath) throws Exception {
        System.out.println(filePath);
        // 模拟文件，myfile.txt为需要下载的文件
        // String file =
        // request.getSession().getServletContext().getRealPath("..\\upload")+"\\"+teacherName+"\\"+courseName+"\\"+fileName;
        // String file = "D:\\upload"+"\\"+teacherName+"\\"+courseName+"\\"+fileName;
        // 获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
        // 假如以中文名下载的话
        // String filename = "下载文件.txt";
        // 转码，免得文件名中文乱码
        String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
        String filename = URLEncoder.encode(fileName, "UTF-8");
        // 设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        // 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while ((len = bis.read()) != -1) {
            out.write(len);
            out.flush();
        }
        out.close();
        bis.close();
    }

    @RequestMapping("/download.do")
    public void download(String filePath, HttpServletRequest request, HttpServletResponse response) {
        try {
            // filePath = new String(filePath.getBytes("gb2312"),"utf-8");
            // 获取文件名
            String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);

            System.out.println("filePath:" + filePath + "  fileName:" + fileName);

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            // 处理下载弹出框名字的编码问题
            response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
            // 获取文件的下载路径
            // String path = request.getSession().getServletContext().getRealPath(filePath);
            // System.out.println("path:"+path);
            // 利用输入输出流对文件进行下载
            InputStream inputStream = new FileInputStream(filePath);

            OutputStream os = response.getOutputStream();

            byte[] b = new byte[1024];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            // 这里主要关闭。
            os.close();

            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回值要注意，要不然就出现下面这句错误！
        // java+getOutputStream() has already been called for this response
    }

    @RequestMapping("/newdownload.do")
    public void newdownload(@RequestParam("fileName") String fileName, @RequestParam("courseName") String courseName, @RequestParam("teacherName") String teacherName, HttpServletResponse response) throws Exception {

        fileName = new String(fileName.getBytes("iso8859-1"), "utf-8");
        courseName = new String(courseName.getBytes("iso8859-1"), "utf-8");
        teacherName = new String(teacherName.getBytes("iso8859-1"), "utf-8");

        System.out.println(fileName);
        String filePath = "C:\\upload" + "\\" + teacherName + "\\" + courseName + "\\" + fileName;
        System.out.println(filePath);
        File file = new File(filePath);
        if (file.exists()) {
            //重置response  
            System.out.println("文件存在");
            //response.reset();
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            // 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            //设置http头信息的内容  
            String downloadFielName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
            response.addHeader("Content-Disposition", "attachment;filename=\"" + downloadFielName + "\"");
            //设置文件长度  
            int fileLength = (int) file.length();
            response.setContentLength(fileLength);
            if (fileLength != 0) {
                InputStream inStream = new FileInputStream(file);
                byte[] buf = new byte[4096];
                //创建输出流  
                ServletOutputStream servletOS = response.getOutputStream();
                int readLength;
                //读取文件内容并写入到response的输出流当中  
                while ((readLength = inStream.read(buf)) != -1) {
                    servletOS.write(buf, 0, readLength);
                }
                //关闭输入流  
                inStream.close();
                //刷新输出流缓冲  
                servletOS.flush();
                //关闭输出流  
                servletOS.close();
            }
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("文件\"" + fileName + "\"不存在");
        }
    }

    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename) throws Exception {
        //下载文件路径
        String path = request.getServletContext().getRealPath("/images/");
        File file = new File(path + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(filename.getBytes("UTF-8"), "iso-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/uploadHomework.do")
    @ResponseBody
    public String uploadHomework(MultipartFile file, HttpServletRequest request, String teacherName, String courseName, String courseId, String studentId)
            throws IOException {
        // String path =
        // request.getSession().getServletContext().getRealPath("..\\upload");
        String path = "C:\\homework";
        String fileName = file.getOriginalFilename();
        path = path + "\\" + teacherName + "\\" + courseName;
        File dir = new File(path, fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // MultipartFile自带的解析方法
        file.transferTo(dir);
        //System.out.println(path);
        //System.out.println(fileName);

        String msg = homeworkService.uploadHomework(fileName, studentId, courseId);
        return msg;
    }

    @RequestMapping(value = "/loadHomework.do")
    @ResponseBody
    public List<Homework> listHomework(String teacherName, String courseName, String courseId, String studentId) {
//        String path = "D:\\homework" + "\\" + teacherName + "\\" + courseName;
//        Map<String, String> filesMap = new HashMap<String, String>();
//        File file = new File(path);
//        listfile(file, filesMap);
//        // request.setAttribute("list", list);
//        // System.out.println(filesMap);
//        Iterator<Map.Entry<String, String>> it = filesMap.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry<String, String> entry = it.next();
//            System.out.println("文件名:" + entry.getKey() + "\t绝对路径:" + entry.getValue());
//        }
//        return filesMap;
//        // request.getRequestDispatcher("/download.jsp").forward(request, response);
        List<Homework> list = homeworkService.listHomework(studentId, courseId);
        return list;
    }

    @RequestMapping(value = "/loadAllHomework.do")
    @ResponseBody
    public List<Homework> listHomework(String courseId) {
        List<Homework> list = homeworkService.listAllHomework(courseId);
        return list;
    }

    @RequestMapping("/downloadWork.do")
    public void downloadWork(@RequestParam("fileName") String fileName, @RequestParam("courseName") String courseName, @RequestParam("teacherName") String teacherName, HttpServletResponse response) throws Exception {

        fileName = new String(fileName.getBytes("iso8859-1"), "utf-8");
        courseName = new String(courseName.getBytes("iso8859-1"), "utf-8");
        teacherName = new String(teacherName.getBytes("iso8859-1"), "utf-8");

        System.out.println(fileName);
        String filePath = "C:\\homework" + "\\" + teacherName + "\\" + courseName + "\\" + fileName;
        System.out.println(filePath);
        File file = new File(filePath);
        if (file.exists()) {
            //重置response
            System.out.println("文件存在");
            //response.reset();
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            // 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            //设置http头信息的内容
            String downloadFielName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
            response.addHeader("Content-Disposition", "attachment;filename=\"" + downloadFielName + "\"");
            //设置文件长度
            int fileLength = (int) file.length();
            response.setContentLength(fileLength);
            if (fileLength != 0) {
                InputStream inStream = new FileInputStream(file);
                byte[] buf = new byte[4096];
                //创建输出流
                ServletOutputStream servletOS = response.getOutputStream();
                int readLength;
                //读取文件内容并写入到response的输出流当中
                while ((readLength = inStream.read(buf)) != -1) {
                    servletOS.write(buf, 0, readLength);
                }
                //关闭输入流
                inStream.close();
                //刷新输出流缓冲
                servletOS.flush();
                //关闭输出流
                servletOS.close();
            }
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("文件\"" + fileName + "\"不存在");
        }
    }
}