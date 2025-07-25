package com.example.easyepubtransfer.ui.states

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.easyepubtransfer.R
import com.example.easyepubtransfer.ui.theme.EasyEPUBTransferTheme

@Composable
fun DefaultView(message: String = stringResource(R.string.defaultMessage)) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        Spacer(modifier = Modifier.weight(0.3f))

        Icon(
            painter = painterResource(R.drawable.usb_24px),
            contentDescription = stringResource(id = R.string.usb_icon_content_description),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(96.dp)
        )

        Spacer(modifier = Modifier.weight(0.2f))

        Text(
            text = message,
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.weight(0.3f))

        Icon(
            painter = painterResource(R.drawable.cable_24px),
            contentDescription = stringResource(id = R.string.cable_icon_content_description),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(64.dp)
        )

        Spacer(modifier = Modifier.weight(0.05f))

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultViewPreview() {
    EasyEPUBTransferTheme {
        DefaultView()
    }
}