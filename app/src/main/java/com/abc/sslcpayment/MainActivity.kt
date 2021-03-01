package com.abc.sslcpayment


import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCommerzInitialization
import com.sslwireless.sslcommerzlibrary.model.response.SSLCTransactionInfoModel
import com.sslwireless.sslcommerzlibrary.model.util.SSLCCurrencyType
import com.sslwireless.sslcommerzlibrary.model.util.SSLCSdkType
import com.sslwireless.sslcommerzlibrary.view.singleton.IntegrateSSLCommerz
import com.sslwireless.sslcommerzlibrary.viewmodel.listener.SSLCTransactionResponseListener


class MainActivity : AppCompatActivity(), SSLCTransactionResponseListener {

    private val TAG = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        processPayment()
    }

    fun processPayment() {
        val sslCommerzInitialization = SSLCommerzInitialization("test603b5dedc3b86",
                "test603b5dedc3b86@ssl",
                10.00,
                SSLCCurrencyType.BDT, //Currency type
                 "1212", "test",
                SSLCSdkType.TESTBOX //SDK type for live payment use SSLCSdkType.TESTBOX for test mode
        )

        IntegrateSSLCommerz
                .getInstance(this)
                .addSSLCommerzInitialization(sslCommerzInitialization)
                .buildApiCall(this)

    }

    override fun transactionFail(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun merchantValidationError(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun transactionSuccess(p0: SSLCTransactionInfoModel?) {
                exitDialog()
    }




    fun exitDialog(){
        AlertDialog.Builder(this)
                .setMessage("Payment success")
                .setCancelable(false)
                .setPositiveButton("Yes", DialogInterface.OnClickListener {
                    dialog, id ->

                })
                .setNegativeButton("No", null)
                .show()
    }
}