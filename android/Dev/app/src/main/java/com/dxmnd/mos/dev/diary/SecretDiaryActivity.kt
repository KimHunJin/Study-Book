package com.dxmnd.mos.dev.diary

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.dxmnd.mos.dev.R

class SecretDiaryActivity : AppCompatActivity() {

    // 너와 나만의 다이어리
    // 시크릿 키를 이용하여 작성한 글을 저장한다.

    // 사용자는 시크릿키로 검색을 하여 자기 혹은 같은 시크릿키를 이용하는 다른 사용자의 글을 볼 수 있다.
    // 지인에게 알리고 싶지는 않으나 특정 누군가가 알아봐줬으면 하는 취지로서 만들었다.

    // 작성한 글은 시크릿키로 복호화 가능하다.

    // 작성된 시크릿 데이터 리스트를 보여준다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secret_diary)
    }
}
