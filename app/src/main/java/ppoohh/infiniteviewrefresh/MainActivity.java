package ppoohh.infiniteviewrefresh;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.support.v7.widget.RecyclerView.*;
import android.support.v7.widget.RecyclerView.*;
import android.support.v7.widget.RecyclerView.*;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.grid_view);
		recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
		RecyclerView.Adapter<MyViewHolder> adapter = new RecyclerView.Adapter<MyViewHolder>() {
			@Override
			public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
				ViewGroup v = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.my_view_holder, parent, false);
				return new MyViewHolder(v);
			}

			@Override
			public void onBindViewHolder(MyViewHolder holder, int position) {
				holder.tv.setText(String.format("position %s", position));
			}

			@Override
			public int getItemCount() {
				return 5000;
			}
		};
		recyclerView.setAdapter(adapter);
		View view = findViewById(R.id.system_message_container);
		view.setVisibility(View.VISIBLE);
	}

	private static class MyViewHolder extends ViewHolder {

		private TextView tv;

		private MyViewHolder(ViewGroup parent) {
			super(parent);
			tv = (TextView) parent.findViewById(R.id.foo);
		}
	}
}
