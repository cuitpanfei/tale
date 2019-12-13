package com.tale;

import java.util.function.Function;

import com.blade.Blade;
import com.blade.kit.StringKit;
import com.blade.mvc.http.Request;
import com.blade.security.web.csrf.CsrfMiddleware;
import com.blade.security.web.csrf.CsrfOption;
import com.tale.bootstrap.TaleLoader;

/**
 * Tale启动类
 *
 * @author biezhi
 */
public class Application {
	static final Function<Request, String> DEFAULT_TOKEN_GETTER = request -> request.query("_token").orElseGet(() -> {
        if (StringKit.isNotBlank(request.header("pf_csrf_token"))) {
            return request.header("pf_csrf_token");
        }
        if (StringKit.isNotBlank(request.header("xsrf_token"))) {
            return request.header("xsrf_token");
        }
        return "";
    });

    public static void main(String[] args) {
        Blade blade = Blade.of();
        TaleLoader.init(blade);
        CsrfOption option = CsrfOption.builder().tokenGetter(DEFAULT_TOKEN_GETTER).build();
        blade.use(new CsrfMiddleware(option)).start(Application.class, args);
    }

}