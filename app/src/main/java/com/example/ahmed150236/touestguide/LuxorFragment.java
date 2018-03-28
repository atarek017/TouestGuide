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
public class LuxorFragment extends Fragment {


    public LuxorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<Place> place = new ArrayList<Place>();
        Location karnak = new Location(R.string.karnak + "");
        karnak.setLatitude(25.7188);
        karnak.setLongitude(32.6573);
        place.add(new Place(R.string.karnak, R.string.Karnak_location, R.drawable.karnak, karnak));

        Location luxorTemple = new Location(R.string.luxor_catogry + "");
        luxorTemple.setLatitude(25.6995);
        luxorTemple.setLongitude(32.6391);
        place.add(new Place(R.string.luxor_temple, R.string.luxor_temple_location, R.drawable.luxortemple, luxorTemple));

        Location valleyOfTheKings = new Location(R.string.valley_of_the_kings + "");
        valleyOfTheKings.setLatitude(25.7402);
        valleyOfTheKings.setLongitude(32.6014);
        place.add(new Place(R.string.valley_of_the_kings, R.string.valley_of_the_kings_location, R.drawable.valleyofthekings, valleyOfTheKings));

        Location mummificationMuseum = new Location(R.string.mummification_museum + "");
        mummificationMuseum.setLatitude(25.7023);
        mummificationMuseum.setLongitude(32.6399);
        place.add(new Place(R.string.mummification_museum, R.string.mummification_museum_location, R.drawable.mummificationmuseum, mummificationMuseum));

        Location greatHypostyleHall = new Location(R.string.great_hypostyleh_hall + "");
        greatHypostyleHall.setLatitude(25.7186);
        greatHypostyleHall.setLongitude(32.6579);
        place.add(new Place(R.string.great_hypostyleh_hall, R.string.great_hypostyleh_hall_location, R.drawable.greathypostylehall, greatHypostyleHall));

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
