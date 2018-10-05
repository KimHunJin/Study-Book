package dxmnd.com.rightnow.service

import dxmnd.com.rightnow.util.TOKEN
import okhttp3.*
import java.io.IOException


class MockInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        addDelay()

        return Response.Builder()
                .header("token", TOKEN)
                .code(200)
                .message("OK")
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), "{}"))
                .build()
    }

    private fun addDelay() {

        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }
}