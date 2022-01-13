package com.example.final_smd;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


//import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class rocketFragment extends Fragment {
    View view;
    TextView direction,distances,fuel,launchTime,oxygenlevel,rocketNo,speed;;
    private RecyclerView recyclerView;
    DatabaseReference reference;
    FirebaseAuth mauth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment01,container,false);

        direction = view.findViewById(R.id.textView13);
        speed = view.findViewById(R.id.textView14);
        distances = view.findViewById(R.id.textView15);
        launchTime = view.findViewById(R.id.textView16);
        //  recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://final-smd-default-rtdb.firebaseio.com/");
        reference = firebaseDatabase.getReference().child("rocket");
        Query checkname = reference.orderByChild("direction").equalTo("N");
        checkname.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String d = snapshot.child("rocket1").child("direction").getValue(String.class);
                    Log.d("TAG", "onDataChange: " + d);
                    direction.setText(snapshot.child("rocket1").child("direction").getValue(String.class));
                    distances.setText(snapshot.child("rocket1").child("Distance").getValue(String.class));
                    speed.setText(snapshot.child("rocket1").child("speed").getValue(String.class));
                    launchTime.setText(snapshot.child("rocket1").child("TimeElapsed").getValue(String.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        return view;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//
//        FirebaseRecyclerOptions<Rocket> options = new FirebaseRecyclerOptions.Builder<Rocket>().setQuery(reference,Rocket.class).build();
//
//        FirebaseRecyclerAdapter<Rocket,ContactsViewHolder> adapter = new FirebaseRecyclerAdapter<Rocket, ContactsViewHolder>(options) {
//            @Override
//            protected void onBindViewHolder(@NonNull ContactsViewHolder contactsViewHolder, int i, @NonNull Rocket rocket) {
//
//                reference.addListenerForSingleValueEvent(new ValueEventListener() {
//                    String name = null;
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        name = snapshot.child("direction").getValue(String.class);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//
//                });
//                contactsViewHolder.userName.setText("de");
//                contactsViewHolder.userStatus.setText("etre");
//                contactsViewHolder.fuel.setText("qwerty");
//            }
//
//            @NonNull
//            @Override
//            public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.recylerview,parent,false);
//                return new ContactsViewHolder(view1);
//            }
//
//        };
//        recyclerView.setAdapter(adapter);
//        adapter.startListening();
//    }
//
//    public static class ContactsViewHolder extends RecyclerView.ViewHolder
//    {
//        TextView userName, userStatus,fuel;
//
//
//        public ContactsViewHolder(@NonNull View itemView)
//        {
//            super(itemView);
//
//            userName = itemView.findViewById(R.id.Direction);
//            userStatus = itemView.findViewById(R.id.Distances);
//            fuel = itemView.findViewById(R.id.fuel);
//            //onlineIcon = (ImageView) itemView.findViewById(R.id.user_online_status);
//        }
//    }
}
