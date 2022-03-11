package com.example.bookstore.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookstore.R;


public class BasketFragment extends Fragment {



    public BasketFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_basket, container, false);
    
        Book[] books = {
                new Book("https://img4.labirint.ru/rc/6e014b85dee833b1523c2087b587b99d/220x340/books81/801294/cover.png?1639499102",
                        "Шторм на Лазурном берегу",
                        520),
                new Book("https://img3.labirint.ru/rc/35332c933f1c89ec85e92bc894f296d3/220x340/books84/838691/cover.png?1646907907",
                        "Крокодил из страны Шарлотты",
                        784)
        };
    
        BasketAdapter basketAdapter = new BasketAdapter(books);
        RecyclerView recyclerView = view.findViewById(R.id.basketRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(basketAdapter);
        
        return view;
    }
}