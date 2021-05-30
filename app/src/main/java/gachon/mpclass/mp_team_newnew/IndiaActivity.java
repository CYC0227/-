package gachon.mpclass.mp_team_newnew;

import androidx.appcompat.app.AppCompatActivity;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class IndiaActivity extends AppCompatActivity {
    static final String VIDEO_URL = "https://r1---sn-oguelney.googlevideo.com/videoplayback?expire=1622381623&ei=1z-zYJrGI9CGjuMPjpyEyAQ&ip=83.136.177.178&id=o-AO-7ULcbrQp1uFfq6gGwNbZp1Pos5_1mVm3caDJ2KmIc&itag=18&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=MrASh34ZGzy9P-zkToE-3RgF&gir=yes&clen=21908402&ratebypass=yes&dur=288.786&lmt=1603524293200334&fexp=9466587,24001373,24007246&beids=9466587&c=WEB&txp=5430434&n=p9fkCd3hFril0mWS&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRgIhALNYiNzFOG3bsBmB1K60ELRGYzFHxY1BrrJR1idINqMJAiEAo2K8SqAbC9keHLmN96QJWClcGE9os2ZtLeQ_YDscwy0%3D&rm=sn-nxg8pivnupob-cjoe7e,sn-nxg8pivnupob-h5qz7e,sn-h5qzr7e&req_id=8f96f7845b9ea3ee&redirect_counter=3&cms_redirect=yes&ipbypass=yes&mh=Nh&mip=49.1.155.104&mm=30&mn=sn-oguelney&ms=nxu&mt=1622359436&mv=u&mvi=1&pl=21&lsparams=ipbypass,mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRAIgefRs1X2IVul6YaRxmfQ5g6-wCT5ILZbTbr4rb0zjhNcCIEiLo9MGouaqEIVUPw4qtK6a98h3d0iSH_WqhRkRC6_E";
    static final String VIDEO_URL2 = "https://r4---sn-ogueln7d.googlevideo.com/videoplayback?expire=1622381726&ei=PkCzYPX1LfX54-EPx6exgAo&ip=137.59.163.199&id=o-AH4ciAospZMTtE4xE4U6CR60gObt3AgdV9daMg4nfitk&itag=18&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=L0K9f6S1Mt36HjmnwNIbyiUF&gir=yes&clen=21908189&ratebypass=yes&dur=274.692&lmt=1603376121655608&fexp=24001373,24007246&c=WEB&txp=5430434&n=Ru5HHMHbN-ojYx6i&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAPEGOkQ6KDdBnFkzbCQ0vud9yw7TioYitpAGVzgS2052AiAlgB4KmgkZ2jvt9tk4GfxbHeJGYUxOqs9N6a_HUQUVIw%3D%3D&rm=sn-2ugxh5a5-jb3s7z,sn-nposs7z&req_id=ce60fa38f600a3ee&redirect_counter=2&cms_redirect=yes&ipbypass=yes&mh=5m&mip=49.1.155.104&mm=29&mn=sn-ogueln7d&ms=rdu&mt=1622359981&mv=m&mvi=4&pl=21&lsparams=ipbypass,mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRgIhANY_KbpjaHnWJVAr_MygSMzJXe8VXQ1uWiAW8jVXivDqAiEAjMb4W1-SKCrIDS6OLtMn-cUE9yntvx6zY_VdFqkq3Wk%3D";
    static final String VIDEO_URL3 = "https://r1---sn-ogul7nll.googlevideo.com/videoplayback?expire=1622322693&ei=pVmyYJPyOIWOlQTriYHIAw&ip=95.30.150.219&id=o-AElXm6pNQCbNhkpjmN1Ks5XcNRBhvCSTTqoHlCljPjVx&itag=18&source=youtube&requiressl=yes&pcm2=yes&vprv=1&mime=video%2Fmp4&ns=LNP_POR1MN3xRs3iZFfCnuYF&gir=yes&clen=26018059&ratebypass=yes&dur=474.731&lmt=1612326657010923&fexp=24001373,24007246&c=WEB&txp=5530422&n=roq2_RTp3NgTHoZD&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cpcm2%2Cvprv%2Cmime%2Cns%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAL_ojDlWR0q10yH3YKR_SN5VG0ezTH_xwsMmpugjPC15AiAVlwwu_V6b7VMrjQN3tPVLLU8I69UxLg6XH3aqRseqow%3D%3D&rm=sn-8ph2xajvh-8v1l7e,sn-n8vysee&req_id=856aa8de3555a3ee&redirect_counter=2&cms_redirect=yes&ipbypass=yes&mh=20&mip=49.1.155.104&mm=29&mn=sn-ogul7nll&ms=rdu&mt=1622300945&mv=m&mvi=1&pl=21&lsparams=ipbypass,mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRQIhANuDucH4QSAuzl72eTLxrc2nVQLEao6JOKdaQUkKcbxCAiA0TIh6J5Nv-xDqn02dCjQFq4OFF-DjFYSo67KEo5z0Sw%3D%3D";
    private VideoView videoView;
    private VideoView videoView2;
    private VideoView videoView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india);
        videoView = (VideoView) findViewById(R.id.videoView);
        videoView2 = (VideoView) findViewById(R.id.videoView2);

        MediaController mc = new MediaController(this);
        MediaController mc2 = new MediaController(this);
        videoView.setMediaController(mc);
        videoView.setVideoURI(Uri.parse(VIDEO_URL));
        videoView2.setMediaController(mc2);
        videoView2.setVideoURI(Uri.parse(VIDEO_URL2));


        //Button startBtn = (Button) findViewById(R.id.startBtn);
        //Button volumeBtn = (Button) findViewById(R.id.volumeBtn);
//        startBtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                videoView.seekTo(0);
//                videoView.start();
//            }
//        });
//        volumeBtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                AudioManager mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
//                int maxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
//                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, AudioManager.FLAG_SHOW_UI);
//            }
//        });

//        //
//        Button startBtn2 = (Button) findViewById(R.id.startBtn2);
//        Button volumeBtn2 = (Button) findViewById(R.id.volumeBtn2);
//        startBtn2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                videoView2.seekTo(0);
//                videoView2.start();
//            }
//        });
//        volumeBtn2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                AudioManager mAudioManager2 = (AudioManager) getSystemService(AUDIO_SERVICE);
//                int maxVolume2 = mAudioManager2.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
//                mAudioManager2.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume2, AudioManager.FLAG_SHOW_UI);
//            }
//        });
    }
}
//package gachon.mpclass.mp_team_newnew;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.youtube.player.YouTubeBaseActivity;
//import com.google.android.youtube.player.YouTubeInitializationResult;
//import com.google.android.youtube.player.YouTubePlayer;
//import com.google.android.youtube.player.YouTubePlayerView;
//
//public class IndiaActivity extends YouTubeBaseActivity { // YouTubeBaseActivity 상속받도록 해야 오류가 안남.
//    YouTubePlayerView playerView;
//    YouTubePlayer player;
//
//    static String API_KEY ="AIzaSyDirB_tslfQ4GcpdLL57n0f-aXNsXtq36g"; // 구글 콘솔사이트에서 발급받는 키
//    static String videoId = "F5xj2QPZPAo"; // 재생할 동영상의 id값
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_india);
//
//        initPlayer();
//
//        Button button = findViewById(R.id.youtubeButton);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                playVideo();
//            }
//        });
//    } // onCreate
//
//    public void initPlayer() {
//        playerView = findViewById(R.id.youtubeView);
//        // YouTubePlayerView 초기화하기
//        playerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider,
//                                                YouTubePlayer youTubePlayer, boolean b) {
//                player = youTubePlayer;
//                player.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
//                    @Override
//                    public void onLoading() {}
//
//                    @Override
//                    public void onLoaded(String s) {
//                        Log.e("PlayerView", "onLoaded 호출됨: " + s);
//                        player.play(); // 동엿앙이 로딩되었으면 재생하기
//                    }
//
//                    @Override
//                    public void onAdStarted() {}
//
//                    @Override
//                    public void onVideoStarted() {}
//
//                    @Override
//                    public void onVideoEnded() {}
//
//                    @Override
//                    public void onError(YouTubePlayer.ErrorReason errorReason) {}
//                });
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider,
//                                                YouTubeInitializationResult youTubeInitializationResult) {}
//        });
//    } // initPlayer
//
//    public void playVideo() {
//        if (player != null) {
//            if (player.isPlaying()) {
//                player.pause();
////                player.cueVideo(videoId); // 여기에 있으면 동영상 재생이 안됨.
//            }
//            player.cueVideo(videoId);
//        }
//    }
////////////////////////////////////////////////////////////////
//} // class
//public class IndiaActivity extends AppCompatActivity {
//    YouTubePlayerView youtubeView;
//    Button button;
//    YouTubePlayer.OnInitializedListener listener;
//    @Override protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_india);
//
//        button = (Button) findViewById(R.id.youtubeButton);
//        youtubeView = (YouTubePlayerView) findViewById(R.id.youtubeView);
//        listener = new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                youTubePlayer.loadVideo("F5xj2QPZPAo");
//            }
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
//            }
//        };
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                youtubeView.initialize("AIzaSyDirB_tslfQ4GcpdLL57n0f-aXNsXtq36g",listener);
//            }
//        });
//    }
//}


//public class IndiaActivity extends YouTubeBaseActivity{
//    //객체 선언
//    YouTubePlayerView playerView;
//    YouTubePlayer player;
//    //유튜브 API KEY와 동영상 ID 변수 설정
//    private static String API_KEY = "AIzaSyDirB_tslfQ4GcpdLL57n0f-aXNsXtq36g";
//    //https://www.youtube.com/watch?v=hl-ii7W4ITg ▶ 유튜브 동영상 v= 다음 부분이 videoId
//    private static String videoId = "F5xj2QPZPAo";
//
//    //logcat 사용 설정
//    private static final String TAG = "IndiaActivity";
//
//    @Override protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_india);
//
//        initPlayer();
//
//        Button btnPlay = findViewById(R.id.youtubeBtn);
//        btnPlay.setOnClickListener(new View.OnClickListener() {
//            @Override public void onClick(View view) {
//                playVideo();
//            }
//
//        });
//    }
//
//
//    private void playVideo() {
//        if(player != null) {
//            if(player.isPlaying()) {
//                player.pause();
//            }
//            player.cueVideo(videoId); }
//    }
//
//    private void initPlayer() {
//        playerView = findViewById(R.id.youTubePlayerView);
//        playerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                player = youTubePlayer;
//                player.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
//                    @Override public void onLoading() { }
//                    @Override public void onLoaded(String id) {
//                        Log.d(TAG, "onLoaded: " + id); player.play();
//                    }
//                    @Override
//                    public void onAdStarted() { }
//                    @Override public void onVideoStarted() { }
//                    @Override public void onVideoEnded() { }
//                    @Override public void onError(YouTubePlayer.ErrorReason errorReason) {
//                        Log.d(TAG, "onError: " + errorReason);
//                    }
//                });
//            }
//            @Override public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) { } }); } }
//