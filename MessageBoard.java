import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * MessageBoard class.
 * 
 * @author jeromeli
 * 
 */
public class MessageBoard {

  private HashMap<Integer, ArrayList<Integer>> msg;
  private ArrayList<String> map;

  /**
   * message board constructor.
   */
  public MessageBoard() {

    msg = new HashMap<Integer, ArrayList<Integer>>();
    map = new ArrayList<String>();

  }

  /**
   * Add a new message to the board.
   * 
   * @param text The text of the message
   * @return The message id.
   */
  public int addMessage(String text) {

    map.add(text);
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(map.size() - 1);
    msg.put(map.size() - 1, new ArrayList<Integer>());

    return map.size() - 1;
  }

  /**
   * Add a reply to an existing message.
   * 
   * @param msgId The message to reply to
   * @param text The text of the message
   * @return The new message id
   */
  public int addReply(int msgId, String text) {

    map.add(text);

    if (msg.get(msgId) == null) {
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(map.size() - 1);
      msg.put(msgId, list);

    } else {
      msg.get(msgId).add(map.size() - 1);
    }

    return map.size() - 1;
  }

  /**
   * Return the text for a message.
   */
  public String getMessageText(int msgId) {

    return map.get(msgId);

  }

  /**
   * Get the list of replies for a particular message (in order).
   * 
   * @param msgId The message
   * @return A List of message ids corresponding to replies
   */
  public List<Integer> getReplies(int msgId) {

    if (msg.get(msgId) == null) {
      return new ArrayList<Integer>();
    }

    return msg.get(msgId);
  }

  /**
   * A thread is composed of a message, all the replies to that message, all replies to the replies,
   * etc. The returned list will be in the order the posts would appear on the board. I.e. replies
   * appear after the message they are replying to.
   * 
   * @param msgId The start of the thread
   * @return A List of all messages in the thread
   */
  public List<Integer> getThread(int msgId) {

    ArrayList<Integer> result = new ArrayList<Integer>();
    result.add(msgId);
    for (Integer i : getReplies(msgId)) {
      result.addAll(getThread(i));
    }
    return result;
  }

}
