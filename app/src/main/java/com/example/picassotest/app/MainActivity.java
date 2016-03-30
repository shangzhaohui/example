package com.example.picassotest.app;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.style.DoubleBounce;

public class MainActivity extends MainBaseActivity {
	Square square = new Square();
	/**
	 * ATTENTION: This was auto-generated to implement the App Indexing API.
	 * See https://g.co/AppIndexing/AndroidStudio for more information.
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final SpinKitView progressBar = (SpinKitView) findViewById(R.id.spin_kit);
		progressBar.setIndeterminateDrawable(new DoubleBounce());

//		final String url = "http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg";
		final String url = "http://ww.daliulian.net/imgs/image/47/4788833.jpg";
//		final String url = "http://1.bp.blogspot.com/--4r1PZXYtlY/VCf_SbrYYHI/AAAAAAAAeVQ/lzRoIhwE6yU/s1600/greatest-superhero-gif-ever.gif";
		final ImageView imageView = (ImageView) findViewById(R.id.image);
		final ImageView imageView1 = (ImageView) findViewById(R.id.image1);

		final CountAnimationTextView textView = (CountAnimationTextView) findViewById(R.id.count_textview);
		Button btn = (Button) findViewById(R.id.btn);
		btn.setText("去listview");
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this,ExpandListViewActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});

		Button btn1 = (Button) findViewById(R.id.btn1);
		btn1.setText("去切图activity");
		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
//				Picasso.with(MainActivity.this).load(url).resize(400, 400).into(imageView1);
//				Picasso.with(MainActivity.this).setIndicatorsEnabled(true);
//								Glide.with(MainActivity.this)
//						.load(url)
//						.crossFade()
//						.into(imageView1);
				Intent intent = new Intent(MainActivity.this,BitmapActivity.class);
				startActivity(intent);
			}
		});
//		mGLView = new MyGLSurfaceView(this);
//		setContentView(mGLView);
		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
	}
	public void rotateAnimaRun(final View view) {
//		ObjectAnimator animator = ObjectAnimator.ofFloat(view, "abc", 0.0F, 1.0F)
//				.setDuration(500);
//				animator.start();
//
//		animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//			@Override
//			public void onAnimationUpdate(ValueAnimator valueAnimator) {
//				float cVal = (Float) valueAnimator.getAnimatedValue();
//				view.setAlpha(cVal);
//				view.setScaleX(cVal);
//				view.setScaleY(cVal);
//			}
//		});
		PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha",1f,0f);
		PropertyValuesHolder pvhy = PropertyValuesHolder.ofFloat("scaleX",1f,0f,1f);
		PropertyValuesHolder pvhz = PropertyValuesHolder.ofFloat("scaleY",1f,0f,1f);
		ObjectAnimator.ofPropertyValuesHolder(view,pvhX,pvhy,pvhz).setDuration(1000).start();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		// noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}


//	// This method will be called when a SomeOtherEvent is posted
//	@Subscribe
//	public void handleSomethingElse(SomeOtherEvent event){
//		doSomethingWith(event);
//	}

	//	private GLSurfaceView mGLView;
//
//
//	class MyGLSurfaceView extends GLSurfaceView
//	{
//
//		public MyGLSurfaceView(Context context)
//		{
//			super(context);
//
//			try
//			{
//				// Create an OpenGL ES 2.0 context
//				setEGLContextClientVersion(2);
//
//				// Set the Renderer for drawing on the GLSurfaceView
//				setRenderer(new MyRenderer());
//
//				// Render the view only when there is a change in the drawing
//				// data
//				setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
//
//				// 注意上面语句的顺序，反了可能会出错
//
//			}
//			catch (Exception e)
//			{
//				e.printStackTrace();
//
//			}
//
//		}
//	}
//
//	public class MyRenderer implements GLSurfaceView.Renderer
//
//	{
//		@Override
//		public void onDrawFrame(GL10 gl) {
////			GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
//			// Clears the screen and depth buffer.
//			gl.glClear(GL10.GL_COLOR_BUFFER_BIT |
//					GL10.GL_DEPTH_BUFFER_BIT);
//			gl.glLoadIdentity();
//			gl.glTranslatef(0, 0, -4);
//			// Draw our square.
//			square.draw(gl); // ( NEW )
//		}
//
//		@Override
//		public void onSurfaceChanged(GL10 gl10, int width, int height) {
////			GLES20.glViewport(0, 0, width, height);
//		}
//
//		@Override
//		public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
////			GLES20.glClearColor(0f, 0.5f, 0.5f, 1.0f);
//		}
//
//
//	}


}
