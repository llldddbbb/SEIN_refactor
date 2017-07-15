
layui.define([ 'layer', 'form'], function (exports) {
    var form = layui.form();
    var $ = layui.jquery;
    //自定义验证
    form.verify({
        result_response: function () {
            var value=$("#lc-captcha-response").val();
            if (value.length < 1) {
                return '请点击人机识别验证';
            }
        },
    });
    //监听登陆提交
    form.on('submit(login)', function (data) {
        var index = layer.load(1);

            layer.close(index);

            $.ajax({
                url:"background/login",
                type:"POST",
                data:{
                    adminName:data.field.accountName,
                    password:data.field.password
                },
                success:function (result) {
                        if(result.success){
                            layer.msg('登陆成功，正在跳转......', { icon: 6 });
                            layer.closeAll('page');
                            setTimeout(function () {
                                location.href = "/SEIN/admin/main";
                            }, 1000);
                        }else{
                            layer.msg(result.msg, { icon: 5 });
                    }
                }
            });
        return false;
    });
    //检测键盘按下
    $('body').keydown(function (e) {
        if (e.keyCode == 13) {  //Enter键
            if ($('#layer-login').length <= 0) {
                login();
            }
        }
    });

    $('.enter').on('click', login);

    function login() {
        var loginHtml = '';
        loginHtml += '<form class="layui-form" action="">';
        loginHtml += '<div class="layui-form-item">';
        loginHtml += '<label class="layui-form-label">账号</label>';
        loginHtml += '<div class="layui-input-inline pm-login-input">';
        loginHtml += '<input type="text" name="accountName"  placeholder="请输入账号"  autocomplete="off" class="layui-input">';
        loginHtml += '</div>';
        loginHtml += '</div>';
        loginHtml += '<div class="layui-form-item">';
        loginHtml += '<label class="layui-form-label">密码</label>';
        loginHtml += '<div class="layui-input-inline pm-login-input">';
        loginHtml += '<input type="password" name="password"  placeholder="请输入密码"  autocomplete="off" class="layui-input">';
        loginHtml += '</div>';
        loginHtml += '</div>';
        loginHtml += '<div class="layui-form-item">';
        loginHtml += '<label class="layui-form-label">人机验证</label>';
        loginHtml += '<div class="layui-input-inline pm-login-input">';
        loginHtml += '<div class="l-captcha" lay-verify="result_response" data-site-key="0c5f2ddcf3eb0f58a678e0c50e0d736e"></div>';
        loginHtml += '</div>';
        loginHtml += '</div>';
        loginHtml += '<div class="layui-form-item" style="margin-top:25px;margin-bottom:0;">';
        loginHtml += '<div class="layui-input-block">';
        loginHtml += ' <button class="layui-btn" style="width:230px;" lay-submit="" lay-filter="login">立即登录</button>';
        loginHtml += ' </div>';
        loginHtml += ' </div>';
        loginHtml += '</form>';
        loginHtml +='<script src="//captcha.luosimao.com/static/dist/api.js"></script>';

        layer.open({
            id: 'layer-login',
            type: 1,
            title: false,
            shade: 0.4,
            shadeClose: true,
            area: ['480px', '270px'],
            closeBtn: 0,
            anim: 1,
            skin: 'pm-layer-login',
            content: loginHtml
        });
        layui.form().render('checkbox');
    }

    exports('index', {});
});

