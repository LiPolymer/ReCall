package top.siwg.recall

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val conBt = findViewById<Button>(R.id.connectionbtn)
        val accBt = findViewById<Button>(R.id.accesbtn)
        val dispBt = findViewById<Button>(R.id.dispbtn)
        val sysBt = findViewById<Button>(R.id.sysbtn)
        val dBt = findViewById<Button>(R.id.devicebtn)
        conBt.setOnClickListener {
            intentJump(
                intentConstructor(
                    "com.android.settings",
                    "com.android.settings.Settings${"$"}NetworkDashboardActivity"
                )
            )
        }
        dBt.setOnClickListener {
            intentJump(
                intentConstructor(
                    "com.android.settings",
                    "com.android.settings.Settings${"$"}ConnectedDeviceDashboardActivity"
                )
            )
        }
        accBt.setOnClickListener {
            intentJump(
                intentConstructor(
                    "com.android.settings",
                    "com.android.settings.Settings${"$"}AccessibilitySettingsActivity"
                )
            )
        }
        sysBt.setOnClickListener {
            intentJump(
                intentConstructor(
                    "com.android.settings",
                    "com.android.settings.Settings${"$"}SystemDashboardActivity"
                )
            )
        }
        dispBt.setOnClickListener {
            intentJump(Intent(Settings.ACTION_DISPLAY_SETTINGS))
        }
    }
    private fun intentJump (intent: Intent ){
        //intent.flags = android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }
    private fun intentConstructor (pkg: String, cls: String) :Intent {
        intent = Intent()
        val component = ComponentName(pkg, cls)
        intent.component = component
        intent.action = "android.intent.action.MAIN"
        return intent
    }
}