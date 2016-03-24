package edu.umd.cs.continents;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A fragment representing a single ContinentName detail screen.
 * This fragment is either contained in a {@link ContinentListActivity}
 * in two-pane mode (on tablets) or a {@link ContinentDetailActivity}
 * on handsets.
 */
public class ContinentDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    public static final String ARG_ITEM_NAME = "item_name";

    private ContinentName mName;
    private ImageView mImage;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ContinentDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CDFragment", "in onCreate");
        if (getArguments().containsKey(ARG_ITEM_ID)) {


            mName = new ContinentName(getArguments().getInt(ARG_ITEM_ID), getArguments().getString(ARG_ITEM_NAME));
            Log.d("arg item id", String.valueOf(getArguments().getInt(ARG_ITEM_ID)));


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.continent_detail, container, false);

        mImage = (ImageView) rootView;
        Log.d("CDFragment", String.valueOf(mName.getId()));
        mImage.setImageResource(mName.getId());
        return rootView;
    }
}
