package im.tox.tox4j.av;

import im.tox.tox4j.av.callbacks.*;
import im.tox.tox4j.av.enums.ToxCallControl;
import im.tox.tox4j.av.exceptions.*;

import java.io.Closeable;

public interface ToxAv extends Closeable {

    @Override
    void close();

    int iterationInterval();

    void iteration();

    void call(int friendNumber, int audioBitRate, int videoBitRate) throws ToxCallException;

    void callbackCall(CallCallback callback);

    void answer(int friendNumber, int audioBitRate, int videoBitRate) throws ToxAnswerException;

    void callControl(int friendNumber, ToxCallControl control) throws ToxCallControlException;

    void callbackCallControl(CallControlCallback callback);

    void setAudioBitRate(int friendNumber, int bitRate) throws ToxBitRateException;

    void setVideoBitRate(int friendNumber, int bitRate) throws ToxBitRateException;

    void callbackRequestVideoFrame(RequestVideoFrameCallback callback);

    void sendVideoFrame(int friendNumber, int width, int height, byte[] y, byte[] u, byte[] v, byte[] a) throws ToxSendFrameException;

    void callbackRequestAudioFrame(RequestAudioFrameCallback callback);

    void sendAudioFrame(int friendNumber, byte[] pcm, int sampleCount, int channels, int samplingRate) throws ToxSendFrameException;

    void callbackReceiveVideoFrame(ReceiveVideoFrameCallback callback);

    void callbackReceiveAudioFrame(ReceiveAudioFrameCallback callback);

}