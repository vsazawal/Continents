package edu.umd.cs.continents;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * An activity representing a list of Continents. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ContinentDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ContinentListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continent_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.continent_list);
        setupRecyclerView(recyclerView);

        if (findViewById(R.id.continent_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(new ContinentNameList()));
        //linear layout manager already set in layout XML
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final ContinentNameList mValues;

        public SimpleItemRecyclerViewAdapter(ContinentNameList items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.continent_list_content, parent, false);
            ViewHolderListener listener = new ViewHolderListener();
            return new ViewHolder(view, listener);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {

            Log.d("RECYCLERVIEW ADAPTER", "in onBindViewHolder");
            final ContinentName item = mValues.get(position);
            holder.getNameView().setText(mValues.get(position).getName());

            holder.tellListenerAboutBoundItem(item);



/*            holder.getNameView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();

                        arguments.putInt(ContinentDetailFragment.ARG_ITEM_ID, item.getId());
                        arguments.putString(ContinentDetailFragment.ARG_ITEM_NAME, item.getName());
                        ContinentDetailFragment fragment = new ContinentDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.continent_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, ContinentDetailActivity.class);
                        intent.putExtra(ContinentDetailFragment.ARG_ITEM_ID, item.getId());
                        intent.putExtra(ContinentDetailFragment.ARG_ITEM_NAME, item.getName());
                        context.startActivity(intent);
                    }
                }
            }); */
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView mNameView;
            private ViewHolderListener mListener;

            public ViewHolder(View itemView, ViewHolderListener listener) {
                super(itemView);
                mListener = listener;
                mNameView = (TextView) itemView.findViewById(R.id.continent_name);
                mNameView.setOnClickListener(mListener);
            }

            public TextView getNameView() {
                return mNameView;
            }

            public void tellListenerAboutBoundItem(ContinentName item) {
                mListener.setItem(item);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mNameView.getText() + "'";
            }
        }

        public class ViewHolderListener implements View.OnClickListener {

            ContinentName mItem;
            ViewHolderListener() {
                mItem = null;
            }

            public void setItem(ContinentName item) {
                mItem = item;
            }

            public void onClick(View v) {

                if (mItem == null) {
                    return;
                }


                if (mTwoPane) {
                    Bundle arguments = new Bundle();

                    arguments.putInt(ContinentDetailFragment.ARG_ITEM_ID, mItem.getId());
                    arguments.putString(ContinentDetailFragment.ARG_ITEM_NAME, mItem.getName());
                    ContinentDetailFragment fragment = new ContinentDetailFragment();
                    fragment.setArguments(arguments);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.continent_detail_container, fragment)
                            .commit();
                } else {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ContinentDetailActivity.class);
                    intent.putExtra(ContinentDetailFragment.ARG_ITEM_ID, mItem.getId());
                    intent.putExtra(ContinentDetailFragment.ARG_ITEM_NAME, mItem.getName());
                    context.startActivity(intent);
                }
            }



        }

    }
}
