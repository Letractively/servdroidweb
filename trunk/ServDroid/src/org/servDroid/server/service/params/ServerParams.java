package org.servDroid.server.service.params;

import android.os.Parcel;
import android.os.Parcelable;

public class ServerParams implements Parcelable {

	private String _wwwPath, _errorPath;
	private int _cacheTime, _port, _maxClients;
	private boolean _fileIndexing;

	/**
	 * Define the parameters needed to start the web server
	 * @param wwwPath
	 * @param errorPath
	 * @param cacheTime
	 * @param fileIndexing
	 * @param port
	 * @param maxClients
	 */
	public ServerParams(String wwwPath, String errorPath, int cacheTime,
			boolean fileIndexing, int port, int maxClients) {
		_wwwPath = wwwPath;
		_errorPath = errorPath;
		_cacheTime = cacheTime;
		_fileIndexing = fileIndexing;
		_port = port;
		_maxClients = maxClients;

	}

	public ServerParams(Parcel in) {
		_errorPath = in.readString();
		_wwwPath = in.readString();
		_cacheTime = in.readInt();
		_cacheTime = in.readInt();
		boolean[] ba = new boolean[1];
		in.readBooleanArray(ba);
		_fileIndexing = ba[0];
		_maxClients = in.readInt();
		_port = in.readInt();

	}

	public static final Parcelable.Creator<ServerParams> CREATOR = new Parcelable.Creator<ServerParams>() { // 5

		public ServerParams createFromParcel(Parcel source) {
			return new ServerParams(source);
		}

		public ServerParams[] newArray(int size) {
			return new ServerParams[size];
		}

	};

	/**
	 * Using this cosntructor it is posible to stop the server
	 */
	public ServerParams() {

	}

	/**
	 * Get the www path where the HTML documents are stored.
	 * 
	 * @return
	 */
	public String getWwwPath() {
		return _wwwPath;
	}

	/**
	 * Get the error path were all the error documents are stored.
	 * 
	 * @return
	 */
	public String getErrorPath() {
		return _errorPath;
	}

	/**
	 * After how many minutes a page will expire in the browser cache
	 * 
	 * @return
	 */
	public int getCacheTime() {
		return _cacheTime;
	}

	/**
	 * Get if the file indexing is enabled.
	 * 
	 * @return true if the file indexing is enabled, false otherwise.
	 */
	public boolean getFileIndexing() {
		return _fileIndexing;
	}

	/**
	 * Set the port connection
	 * 
	 * @return
	 */
	public int getPort() {
		return _port;
	}

	/**
	 * Get the maximum request at the same time allowed.
	 * 
	 * @return
	 */
	public int getMaxClients() {
		return _maxClients;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(_errorPath);
		dest.writeString(_wwwPath);
		dest.writeInt(_cacheTime);
		dest.writeBooleanArray(new boolean[] { _fileIndexing });
		dest.writeInt(_maxClients);
		dest.writeInt(_port);

	}

}
