package com.example.mb_1411;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SongAdapter songAdapter;
    private List<SongModel> songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recycler_view);

        // Create sample data
        songList = new ArrayList<>();
        songList.add(new SongModel("54321", "Nơi này có anh", "Em là ai từ đâu bước đến nơi đây...", "Sơn Tùng M-TP"));
        songList.add(new SongModel("12345", "Lạc trôi", "Người vội đến rồi vội đi...", "Sơn Tùng M-TP"));
        songList.add(new SongModel("98765", "Chúng ta không thuộc về nhau", "Oh I'm sorry babe...", "Sơn Tùng M-TP"));
        songList.add(new SongModel("55555", "Muộn rồi mà sao còn", "Nhìn vào đồng hồ chỉ thấy 1 giờ sáng...", "Sơn Tùng M-TP"));
        songList.add(new SongModel("67890", "Hãy trao cho anh", "Hãy trao cho anh nụ hôn say đắm...", "Sơn Tùng M-TP ft. Snoop Dogg"));
        songList.add(new SongModel("60696", "NẾU EM CÒN TỒN TẠI", "Khi anh bắt đầu 1 tình yêu là lúc anh tự thay", "Trịnh Đình Quang"));
        songList.add(new SongModel("60701", "NGỐC", "Có rất nhiều những câu chuyện Em giấu riêng mình em biết", "Khắc Việt"));
        songList.add(new SongModel("60650", "HÃY TIN ANH LẦN NỮA", "Dẫu cho ta đã sai khi ở bên nhau Có yêu thương", "Thiên Dũng"));
        songList.add(new SongModel("60610", "CHUỖI NGÀY VẮNG EM", "Từ khi em bước ra đi cõi lòng anh ngập tràng bao", "Duy Cường"));
        songList.add(new SongModel("60656", "KHI NGƯỜI MÌNH YÊU KHÓC", "Nước mắt em đang rơi trên những ngón tay Nước mắt em", "Phạm Mạnh Quỳnh"));
        songList.add(new SongModel("60685", "MỜ", "Anh mơ gặp em anh mơ được ôm anh mơ được gần", "Trịnh Thăng Bình"));
        songList.add(new SongModel("60752", "TÌNH YÊU CHẮP VÁ", "Muốn đi xa nơi yêu thương mình từng có Để không nghe", "Mr. Siro"));
        songList.add(new SongModel("60608", "CHỜ NGÀY MƯA TAN", "1 ngày mưa và em khuất xa nơi anh bóng dáng cũ", "Trung Đức"));
        songList.add(new SongModel("60603", "CÂU HỎI EM CHƯA TRẢ LỜI", "Cần nơi em 1 lời giải thích thật lòng Đừng Lặng im", "Yuki Huy Nam"));
        songList.add(new SongModel("60720", "QUA ĐI LẶNG LẼ", "Đôi khi đến với nhau yêu thương chẳng được lâu nhưng khi", "Phan Mạnh Quỳnh"));
        songList.add(new SongModel("60856", "QUÊN ANH LÀ ĐIỀU EM KHÔNG THỂ - REMIX", "Cần thêm bao lâu để em quên đi niềm đau Cần thêm", "Thiên Ngôn"));


        // Initialize adapter
        songAdapter = new SongAdapter(this, songList);

        // Set layout manager and adapter for RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(songAdapter);
    }
}
