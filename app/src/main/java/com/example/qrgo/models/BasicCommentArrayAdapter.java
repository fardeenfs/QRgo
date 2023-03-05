package com.example.qrgo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qrgo.R;
import com.example.qrgo.models.Comment;
import com.example.qrgo.utilities.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BasicCommentArrayAdapter extends ArrayAdapter<Comment> {

    private Context mContext;
    private int mResource;
    private ArrayList<Comment> mComments;

    public BasicCommentArrayAdapter(Context context, int resource, ArrayList<Comment> comments) {
        super(context, resource, comments);
        this.mContext = context;
        this.mResource = resource;
        this.mComments = comments;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Comment comment = mComments.get(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView commentNameTextView = convertView.findViewById(R.id.commentor_name);
        TextView commentTimeTextView = convertView.findViewById(R.id.commented_time);
        TextView commentBodyTimeTextView = convertView.findViewById(R.id.comment_body);
        TextView commentedOnTextView = convertView.findViewById(R.id.commented_on);
        ImageView commentsProfilePictureImageView = convertView.findViewById(R.id.comment_profile_picture);

        commentNameTextView.setText("Hon");
        commentTimeTextView.setText("1 hour ago");
        commentBodyTimeTextView.setText(comment.getCommentString());
        commentedOnTextView.setText(comment.getQrCodeId());

        Picasso.get().load("https://i.imgur.com/DvpvklR.png").transform(new CircleTransform()).into(commentsProfilePictureImageView);

        return convertView;
    }
}
