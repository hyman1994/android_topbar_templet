package com.example.mytopbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TopBar extends RelativeLayout {

	private Button leftButton, rightButton;
	private TextView title;

	// ���button����
	private int leftTextColor;
	private Drawable leftBackground;
	private String leftText;

	// �Ҳ�button����
	private int rightTextColor;
	private Drawable rightBackground;
	private String rightText;

	// title����
	private int titleTextColor;
	private float titleTextSize;
	private String titleText;

	// ��������
	private LayoutParams leftParams, rirhtParams, titleParams;

	private TopBarClickListener listener;

	public TopBar(Context context, AttributeSet attrs){

		super(context, attrs);
		//��ȡ�Զ������Ժ�ֵ��ӳ�伯��
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);

		//ȡ���Զ������� - ���
		leftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, Color.BLACK);
		leftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
		leftText = ta.getString(R.styleable.TopBar_leftText);

		//ȡ���Զ������� - �Ҳ�
		rightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, Color.BLACK);
		rightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
		rightText = ta.getString(R.styleable.TopBar_rightText);

		//ȡ���Զ������� - ����
		titleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor, Color.BLACK);
		titleTextSize = ta.getDimension(R.styleable.TopBar_titleTextSize, 12);
		titleText = ta.getString(R.styleable.TopBar_titleText);
		
		//����TypedArray�������˷���Դ��������Ϊ���浼�µĴ���
		ta.recycle();

		leftButton = new Button(context);
		rightButton = new Button(context);
		title = new TextView(context);

		//�������� - ���
		leftButton.setText(leftText);
		leftButton.setTextColor(leftTextColor);
		leftButton.setBackground(leftBackground);

		//�������� - ���
		rightButton.setText(rightText);
		rightButton.setTextColor(rightTextColor);
		rightButton.setBackground(rightBackground);

		//�������� - ����
		title.setText(titleText);
		title.setTextSize(titleTextSize);
		title.setTextColor(titleTextColor);
		title.setGravity(Gravity.CENTER);

		//�������屳����ɫ
		setBackgroundColor(0xfff59563);

		//���ò��� - ��
		leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
		leftParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
		addView(leftButton, leftParams);//����ť��ӽ�������

		//���ò��� - ��
		rirhtParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rirhtParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
		rirhtParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
		addView(rightButton, rirhtParams);//����ť��ӽ�������

		//���ò��� - ����
		titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
		addView(title, titleParams);//����ť��ӽ�������

		//���ü�����
		leftButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v){

				listener.leftclick();
			}
		});
		rightButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v){

				listener.rightclick();
			}
		});
	}

	// ����¼��������ӿ�
	public interface TopBarClickListener {

		public void leftclick();

		public void rightclick();
	}

	// ���ü�����
	public void setOnTopBarClickListener(TopBarClickListener listener) {
		this.listener = listener;
	}

	public void setLeftIsVisible(boolean visible) {
		if (visible) {
			leftButton.setVisibility(View.VISIBLE);
		} else {
			leftButton.setVisibility(View.GONE);
		}
	}

	public void setRightIsVisible(boolean visible) {
		if (visible) {
			rightButton.setVisibility(View.VISIBLE);
		} else {
			rightButton.setVisibility(View.GONE);
		}
	}

}
