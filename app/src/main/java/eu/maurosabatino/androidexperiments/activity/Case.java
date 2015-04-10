package eu.maurosabatino.androidexperiments.activity;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import eu.maurosabatino.androidexperiments.R;
import eu.maurosabatino.androidexperiments.fragments.NavigationDrawerFragments;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardViewNative;

public class Case extends ActionBarActivity {
    private Toolbar toolbar;
    private ViewGroup mContainerToolbar;
    private NavigationDrawerFragments mDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case);
        setupDrawer();
        //Create a Card
        Card card = new Card(this);

        //Create a CardHeader
        CardHeader header = new CardHeader(this);

        //Add header to card
        card.addCardHeader(header);
        header.setTitle("VIA ALIMONDA");
        card.setTitle("Via Cardinale Gaetano Alimonda 9");
        CardThumbnail thumb = new CardThumbnail(this);

        thumb.setDrawableResource(R.drawable.ic_action);

        card.addCardThumbnail(thumb);

// Add Header to card
        card.addCardHeader(header);
        CardViewNative cardView = (CardViewNative) this.findViewById(R.id.carddemo);

        cardView.setCard(card);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_case, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void setupDrawer() {
        /* Assinging the toolbar object ot the view and setting the the Action bar to our toolbar */
        toolbar = (Toolbar) findViewById(R.id.tool_bar);

        mContainerToolbar = (ViewGroup) findViewById(R.id.container_app_bar);
        //set the Toolbar as ActionBar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //setup the NavigationDrawer
        mDrawerFragment = (NavigationDrawerFragments) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        mDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.DrawerLayout), toolbar);
    }
}
