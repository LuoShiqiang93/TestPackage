# TestPackage
数字签名打包(友盟)测试

####1.数字签名：  
  1》数字签名不需要任何机构认证，开发者自我认证；  
  2》数字签名是建立开发者和程序的信任关系；  
  3》程序要上线必须签名打包：上线的版本叫release;  
  4》没有数字签名的程序无法安装到手机上，google提供了一个默认签名，debug.keystore  

#####备注：有私钥要公钥的一般是非对称加密，典型的是RSA;


####一个签名打包的基本过程：
#####《1》生成签名文件  
1.菜单栏的Build-Generate Signed Apk-第一次选择Create New,做如下操作：
  
	 1》签名文件的存储路径，签名文件的密码(一般6位而且为数字)  
    2》别名：Alias: 别名的密码  
	 3》有效期：过期的话程序功能可正常使用，但是程序版本不能正常升级；  
    4》开发者名称，组织单位，城市，省，国家代号(86)；  
#####《2》使用签名文件， choose exiting..-签名文件的存储路径，签名文件的密码,别名：Alias: 别名的密码.最后生成的包叫release(发布版本);


####验证打包签名是否正确：
#####cmd 执行keytool命令，例如：

    keytool -printcert -file后面跟上META-IMF\CERT.RSA的目录(apk改成zip解压可找到)


安卓市场多，多达200多个，用的同一个签名文件；  
批量打包：推荐的友盟官网：  
1.进入官网添加应用得到AppKey:  
2.添加libs库；  
3.配置清单文件：  
  权限：
      
      <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"></uses-permission>
      <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
      <uses-permission android:name="android.permission.INTERNET"></uses-permission>
      <uses-permission android:name="android.permission.READ_PHONE_STATE"></uses-permission>

  启动类：
  
	 <meta-data android:value="580485f0e0f55a26b0001b5e" android:name="UMENG_APPKEY"></meta-data>
	 <!--渠道市场-->
	 <meta-data android:value="${UMENG_CHANNEL_VALUE}" android:name="UMENG_CHANNEL"/>

4.配置模版Module 下build.gradle,以下内容写在android标签中

	  productFlavors{
	  //apk上传的市场或者渠道的名字，名字自定义，但是不能为中文
	        wandoujia {}
	        baidu {}
	        c360 {}
	        uc {}
	        
        productFlavors.all { flavor ->
            flavor.manifestPlaceholders = [UMENG_CHANNEL_VALUE: name]
        }
    }
