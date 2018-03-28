package com.example.ahmed150236.touestguide;


import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GizakFragment extends Fragment {


    public GizakFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<Place> place = new ArrayList<Place>();
        Location mgreatSphinxofGiza = new Location(R.string.great_hypostyleh_hall_location + "");
        mgreatSphinxofGiza.setLatitude(29.9753);
        mgreatSphinxofGiza.setLongitude(31.1376);
        place.add(new Place(R.string.mgreatSphinxofGiza, R.string.mgreatSphinxofGiza_location, R.drawable.greatsphinxofgiza, mgreatSphinxofGiza));

        Location pyramidsOfGiza = new Location(R.string.pyramids_of_giza + "");
        pyramidsOfGiza.setLatitude(29.9792);
        pyramidsOfGiza.setLongitude(31.1342);
        place.add(new Place(R.string.pyramids_of_giza, R.string.pyramids_of_giza_location, R.drawable.pyramidsofgiza, pyramidsOfGiza));

        Location gizaZoo = new Location(R.string.giza_zoo + "");
        gizaZoo.setLatitude(30.0227);
        gizaZoo.setLongitude(31.2137);
        place.add(new Place(R.string.giza_zoo, R.string.giza_zoo_location, R.drawable.gizazoo, gizaZoo));

        Location ormanGarden = new Location(R.string.orman_garden + "");
        ormanGarden.setLatitude(30.0290);
        ormanGarden.setLongitude(31.2130);
        place.add(new Place(R.string.orman_garden, R.string.orman_garden_location, R.drawable.ormangarden, ormanGarden));

        Location mukhtarMuseum = new Location(R.string.mukhtar_museum + "");
        mukhtarMuseum.setLatitude(30.0290);
        mukhtarMuseum.setLongitude(31.2130);
        place.add(new Place(R.string.mukhtar_museum, R.string.mukhtar_museum_location, R.drawable.mukhtarmuseum, mukhtarMuseum));

        final placeAdpter placeAdpter = new placeAdpter(getActivity(), place);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(placeAdpter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = place.get(position).getcLocation().getLatitude();
                double lon = place.get(position).getcLocation().getLongitude();
                Location keyword = place.get(position).getcLocation();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(String.valueOf(keyword)));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });

        return rootView;
    }

}
