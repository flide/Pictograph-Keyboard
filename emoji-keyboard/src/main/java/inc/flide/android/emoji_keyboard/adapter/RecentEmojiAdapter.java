package inc.flide.android.emoji_keyboard.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import inc.flide.android.emoji_keyboard.InputMethodServiceProxy;
import inc.flide.android.emoji_keyboard.sqlite.EmojiDataSource;

public class RecentEmojiAdapter extends BaseEmojiAdapter {

    public RecentEmojiAdapter(Context context) {
        super((InputMethodServiceProxy) context);
        dataSource = EmojiDataSource.getInstance(context);
        dataSource.openInReadWriteMode();
    }

    private EmojiDataSource dataSource;

    @Override
    public int getCount() {
        emojiList = dataSource.getAllEntriesInDescendingOrderOfCount();
        return emojiList.size();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        dataSource.close();
    }
}