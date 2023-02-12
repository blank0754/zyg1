// This file is auto-generated, don't edit it. Thanks.
package com.example.aliyun;

import com.aliyun.iot20180120.Client;
import com.aliyun.tea.*;
import com.aliyun.iot20180120.models.*;
import com.aliyun.teaopenapi.models.*;
import com.aliyun.teautil.Common;
import com.example.util.QueryInfo;
import com.example.vo.device;
import com.example.vo.open;
import com.example.vo.useropen;
import com.mysql.cj.x.protobuf.MysqlxCursor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sample {

    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.iot20180120.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "iot.cn-shanghai.aliyuncs.com";
        return new com.aliyun.iot20180120.Client(config);
    }
    public boolean UserOpenApi(useropen open) throws Exception {

        Client client = Sample.createClient("LTAINaIFWVhRzmXo", "M6M1DBr6eT1a0eSwmUeDo2brWlGFs7");
        InvokeThingServiceRequest invokeThingServiceRequest = new InvokeThingServiceRequest()
                .setArgs("{\"States\":1}")
                .setIdentifier("GetStates")
                .setIotInstanceId("iot-06z00dcljc38je0")
                .setProductKey("h15i1CX9V5g")
                .setDeviceName(open.getEquipmentId());

        InvokeThingServiceResponse resp = client.invokeThingService(invokeThingServiceRequest);
        String s = Common.toJSONString(TeaModel.buildMap(resp));
        System.out.println(s);
        HashMap map = (HashMap) TeaModel.buildMap(resp);
        Object body = map.get("body");
        HashMap map1 = (HashMap) body;
        Object success = map1.get("Success");
        if (success.equals(true)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean OpenApi(open open) throws Exception {

        Client client = Sample.createClient("LTAINaIFWVhRzmXo", "M6M1DBr6eT1a0eSwmUeDo2brWlGFs7");
        InvokeThingServiceRequest invokeThingServiceRequest = new InvokeThingServiceRequest()
                .setArgs("{\"States\":1}")
                .setIdentifier("GetStates")
                .setIotInstanceId("iot-06z00dcljc38je0")
                .setProductKey("h15i1CX9V5g")
                .setDeviceName(open.getEquipmentId());

        InvokeThingServiceResponse resp = client.invokeThingService(invokeThingServiceRequest);
       String s = Common.toJSONString(TeaModel.buildMap(resp));
        System.out.println(s);
        HashMap map  = (HashMap) TeaModel.buildMap(resp);
        Object body = map.get("body");
        HashMap map1 = (HashMap) body;
        Object success = map1.get("Success");
        if(success.equals(true)){
            return true;
        }else {
            return false;
        }
    }
        public boolean disinfectApi(open open) throws Exception {

            Client client = Sample.createClient("LTAINaIFWVhRzmXo", "M6M1DBr6eT1a0eSwmUeDo2brWlGFs7");
            InvokeThingServiceRequest invokeThingServiceRequest = new InvokeThingServiceRequest()
                    .setArgs("{\"Uvlamp\":1}")
                    .setIdentifier("UvSwitch")
                    .setIotInstanceId("iot-06z00dcljc38je0")
                    .setProductKey("h15i1CX9V5g")
                    .setDeviceName(open.getEquipmentId());

            InvokeThingServiceResponse resp = client.invokeThingService(invokeThingServiceRequest);
            String s = Common.toJSONString(TeaModel.buildMap(resp));
            System.out.println(s);
            HashMap map  = (HashMap) TeaModel.buildMap(resp);
            Object body = map.get("body");
            HashMap map1 = (HashMap) body;
            Object success = map1.get("Success");
            if(success.equals(true)){
                return true;
            }else {
                return false;
            }

    }

    public Map<String, Object> addDeviceApi(device device) throws Exception {
        com.aliyun.iot20180120.Client client = Sample.createClient("LTAINaIFWVhRzmXo", "M6M1DBr6eT1a0eSwmUeDo2brWlGFs7");
        RegisterDeviceRequest registerDeviceRequest = new RegisterDeviceRequest()
                .setIotInstanceId("iot-06z00dcljc38je0")
                .setProductKey("h15i1CX9V5g")
                .setDeviceName(device.getEquipmentId());
        // 复制代码运行请自行打印 API 的返回值
        RegisterDeviceResponse resp = client.registerDevice(registerDeviceRequest);
        return TeaModel.buildMap(resp);
    }


    public Map<String, Object> selectDeviceApi(QueryInfo queryInfo) throws Exception {
        com.aliyun.iot20180120.Client client = Sample.createClient("LTAINaIFWVhRzmXo", "M6M1DBr6eT1a0eSwmUeDo2brWlGFs7");
        QueryDeviceRequest queryDeviceRequest = new QueryDeviceRequest()
                .setProductKey("h15i1CX9V5g")
                .setIotInstanceId("iot-06z00dcljc38je0")
                .setPageSize(queryInfo.getPageSize())
                .setCurrentPage(queryInfo.getPageNumber());
        // 复制代码运行请自行打印 API 的返回值
        QueryDeviceResponse resp = client.queryDevice(queryDeviceRequest);
        return TeaModel.buildMap(resp);
    }


    public Map<String, Object> deleteDeviceApi(device device) throws Exception {
        com.aliyun.iot20180120.Client client = Sample.createClient("LTAINaIFWVhRzmXo", "M6M1DBr6eT1a0eSwmUeDo2brWlGFs7");
        DeleteDeviceRequest deleteDeviceRequest = new DeleteDeviceRequest()
                .setIotInstanceId("iot-06z00dcljc38je0")
                .setDeviceName(device.getEquipmentId())
                .setProductKey("h15i1CX9V5g");
        // 复制代码运行请自行打印 API 的返回值
        DeleteDeviceResponse deleteDeviceResponse = client.deleteDevice(deleteDeviceRequest);
        return TeaModel.buildMap(deleteDeviceResponse);

    }
}

