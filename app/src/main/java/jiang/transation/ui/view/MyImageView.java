package jiang.transation.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import jiang.transation.R;
import jiang.transation.util.MyImageLoader;

public class MyImageView extends RelativeLayout {
	Context mContext;

	ImageView img_content;
	ProgressBar pb_loading;
	
	String mImageUrl = null;

	public MyImageView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		if(!isInEditMode())
			init(context);
	}

	public MyImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		if(!isInEditMode())
			init(context);
	}

	public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
		if(!isInEditMode())
			init(context);
	}

	private void init(Context context) {
		mContext = context;

		LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.layout_imageview, this);

		img_content = findViewById(R.id.circle_avatar);
		pb_loading = findViewById(R.id.pb_loading);
		pb_loading.setVisibility(View.INVISIBLE);
	}
	
	private void showImage(String image_url) {
		if (image_url.equals(mImageUrl))
			return;
		
		mImageUrl = image_url;

		if (!TextUtils.isEmpty(mImageUrl)) {
			MyImageLoader.showImage(img_content, mImageUrl, new SimpleImageLoadingListener(){
				@Override
				public void onLoadingStarted(String imageUri, View view) {
					// Empty implementation
					pb_loading.setVisibility(View.VISIBLE);
				}

				@Override
				public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
					// Empty implementation
					pb_loading.setVisibility(View.GONE);
				}

				@Override
				public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
					// Empty implementation
					pb_loading.setVisibility(View.GONE);
				}

				@Override
				public void onLoadingCancelled(String imageUri, View view) {
					// Empty implementation
					pb_loading.setVisibility(View.GONE);
				}
			});
			
		} else {
			MyImageLoader.cancel(img_content);
			pb_loading.setVisibility(View.GONE);
			
			img_content.setImageResource(R.drawable.default_image_bg);
		}
	}

	public void setImageDrawable(Drawable d) {
		if (img_content != null)
			img_content.setImageDrawable(d);
	}

	public void setImageResource(int resId) {
		if (img_content != null)
			img_content.setImageResource(resId);
	}

	public void setImageBitmap(Bitmap bm) {
		if (img_content != null)
			img_content.setImageBitmap(bm);
	}

	public void setScaleType(ScaleType scaleType) {
		if (img_content != null)
			img_content.setScaleType(scaleType);
	}
	
	public void fitHeightWithRatio(int width, float ratio) {
		ViewGroup.LayoutParams params = getLayoutParams();
		params.width = width;
		params.height = (int)(params.width * ratio);
		setLayoutParams(params);
	}
}
