package com.example.doctorappdemo.feature.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doctorappdemo.R
import com.example.doctorappdemo.core.model.DoctorModel
import com.example.doctorappdemo.feature.detail.componets.ActionItem
import com.example.doctorappdemo.feature.detail.componets.RatingStat
import com.example.doctorappdemo.feature.detail.componets.StateColumn
import com.example.doctorappdemo.feature.detail.componets.VerticalDivider

@Composable
fun DetailBody(
    item: DoctorModel,
    onOpenWebsite: (String) -> Unit,
    onSendSms: (mobile: String, body: String) -> Unit,
    onDial: (mobile: String) -> Unit,
    onDirection: (locationUrl: String) -> Unit,
    onShare: (subject: String, text: String) -> Unit
) {
    val darkPurple = colorResource(R.color.darkPurple)
    val gray = colorResource(R.color.gray)
    val lightPurple= colorResource(R.color.lightPurple)

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 16.dp)
    ) {
        Spacer(Modifier.height(24.dp))
        Text(
            text = item.Name?:"Tieu de",
            color = Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Text(
            text = "Khoa: "+item.Special?:"Chuyên khoa",
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp)

        )
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp,top=16.dp)
        ) {
            Image(painter = painterResource(R.drawable.location),
                contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text(
                text = item.Address?:"Khanh Hoa",
                color = darkPurple,
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            StateColumn(title = "Bệnh Nhân", value = item.Patiens?:"-")
            VerticalDivider(color = gray)
            StateColumn("Kinh nghiệm", value = "${item.Expriense?:0} năm")
            VerticalDivider(color = gray)
            RatingStat(title = "Đánh Giá", rating = item.Rating?: 0.0)
        }
        Text(
            text = "Thông tin Chi Tiết",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        )
        Text(text = item.Biography?:"Không có tiểu sử",
            color = Color.Black,
            modifier = Modifier
                .padding(start = 16.dp,top=8.dp,end=16.dp)
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top=16.dp, bottom = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ActionItem(
                label = "Liên hệ",
                icon = R.drawable.website,
                lightPurple = lightPurple,
                enable = !item.Site.isNullOrBlank()
            ) {
                item.Site?.let(onOpenWebsite)
            }
            ActionItem(
                label = "Nhắn Tin",
                icon = R.drawable.message,
                lightPurple = lightPurple,
                enable = !item.Site.isNullOrBlank()
            ) {
                onSendSms(item.Mobile,"Xin chào bác sĩ ${item.Name}")
            }
            ActionItem(
                label = "Gọi",
                icon = R.drawable.call,
                lightPurple = lightPurple,
                enable = !item.Site.isNullOrBlank()
            ) {
                onDial(item.Mobile)
            }
            ActionItem(
                label = "Phương hướng",
                icon = R.drawable.direction,
                lightPurple = lightPurple,
                enable = !item.Site.isNullOrBlank()
            ) {
                item.Location?.let(onDirection)
            }
            ActionItem(
                label = "Chia Sẽ",
                icon = R.drawable.share,
                lightPurple = lightPurple,
                enable = true
            ) {
                val subject = "Thông tin bác sĩ ${item.Name}"
                val text="${item.Name} - ${item.Address} - ${item.Mobile}"
                onShare(subject,text)
            }
        }
        Button(onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = darkPurple,
                contentColor = Color.White
                )
            )
        {
           Text(text = "Đặt lịch hẹn",
               fontSize = 18.sp,
               fontWeight = FontWeight.Bold,
               modifier = Modifier.padding(vertical = 8.dp)
               )
        }
        Spacer(Modifier.height(8.dp))

    }
}