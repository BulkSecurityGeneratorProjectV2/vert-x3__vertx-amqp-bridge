/*
* Copyright 2016 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package io.vertx.amqpbridge;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.JdkSSLEngineOptions;
import io.vertx.core.net.JksOptions;
import io.vertx.core.net.KeyCertOptions;
import io.vertx.core.net.OpenSSLEngineOptions;
import io.vertx.core.net.PemKeyCertOptions;
import io.vertx.core.net.PemTrustOptions;
import io.vertx.core.net.PfxOptions;
import io.vertx.core.net.ProxyOptions;
import io.vertx.core.net.SSLEngineOptions;
import io.vertx.core.net.TrustOptions;
import io.vertx.proton.ProtonClientOptions;

/**
 * Options for configuring the AmqpBridge.
 */
@DataObject(generateConverter = true, inheritConverter = true)
public class AmqpBridgeOptions extends ProtonClientOptions {

  private boolean replyHandlingSupport = true;
  private String containerId;
  private String vhost;

  public AmqpBridgeOptions() {
  }

  public AmqpBridgeOptions(JsonObject json) {
    AmqpBridgeOptionsConverter.fromJson(json, this);
  }

  /**
   * Sets the value to use as the container-id field in the AMQP Open frame. Some servers and clients use this for the
   * concept of a 'Client ID'. Defaults to null, which indicates a value will be generated by the bridge when the
   * underlying connection is made.
   *
   * @param containerId the container-id to use
   * @return the options
   */
  public AmqpBridgeOptions setContainerId(String containerId) {
    this.containerId = containerId;
    return this;
  }

  /**
   * Gets the value to use as the container-id field in the AMQP Open frame. Defaults to null, which indicates a value
   * will be generated by the bridge when the underlying connection is made.
   *
   * @return the container id, or null if one will be generated
   */
  public String getContainerId() {
    return containerId;
  }

  /**
   * Sets the value to use as the hostname field in the AMQP Open frame. Defaults to null, which indicates the hostname
   * value given when starting the bridge will be used to populate the hostname field.
   *
   * @param vhost the value to use as the hostname field in the AMQP Open frame to indicate a vhost.
   * @return the options
   * @deprecated use {@link #setVirtualHost(String)} option instead.
   */
  @Deprecated
  public AmqpBridgeOptions setVhost(String vhost) {
    this.vhost = vhost;
    return this;
  }

  /**
   * Gets the value to use as the hostname field in the AMQP Open frame to indicate a vhost. Defaults to null, which
   * indicates the hostname value given when starting the bridge will be used to populate the hostname field.
   *
   * @return the hostname, or null to indicate the TCP connection hostname will be used.
   * @deprecated use {@link #getVirtualHost()} option instead.
   */
  @Deprecated
  public String getVhost() {
    return vhost;
  }

  /**
   * Sets whether the bridge should try to enable support for sending messages with a reply handler set, and replying to
   * messages using the message reply methods. Defaults to true. If the server does not advertise support for
   * 'anonymous sender' links then the bridge won't support reply handling regardless of this setting.
   *
   * @param replyHandlingSupport should attempt be made to enable support for sending messages with a reply handler
   * @return the options
   */
  public AmqpBridgeOptions setReplyHandlingSupport(boolean replyHandlingSupport) {
    this.replyHandlingSupport = replyHandlingSupport;
    return this;
  }

  /**
   * Whether the bridge should try to enable support for sending messages with a reply handler set, and replying to
   * messages using the message reply methods. Defaults to true. If the server does not advertise support for
   * 'anonymous sender' links then the bridge won't support reply handling regardless of this setting.
   *
   * @return whether the bridge should try to enable reply handling support
   */
  public boolean isReplyHandlingSupport() {
    return replyHandlingSupport;
  }

  @Override
  public AmqpBridgeOptions addEnabledSaslMechanism(String saslMechanism) {
    super.addEnabledSaslMechanism(saslMechanism);
    return this;
  }

  @Override
  public AmqpBridgeOptions setHeartbeat(int heartbeat) {
    super.setHeartbeat(heartbeat);
    return this;
  }

  @Override
  public AmqpBridgeOptions setSendBufferSize(int sendBufferSize) {
    super.setSendBufferSize(sendBufferSize);
    return this;
  }

  @Override
  public AmqpBridgeOptions setReceiveBufferSize(int receiveBufferSize) {
    super.setReceiveBufferSize(receiveBufferSize);
    return this;
  }

  @Override
  public AmqpBridgeOptions setReuseAddress(boolean reuseAddress) {
    super.setReuseAddress(reuseAddress);
    return this;
  }

  @Override
  public AmqpBridgeOptions setTrafficClass(int trafficClass) {
    super.setTrafficClass(trafficClass);
    return this;
  }

  @Override
  public AmqpBridgeOptions setTcpNoDelay(boolean tcpNoDelay) {
    super.setTcpNoDelay(tcpNoDelay);
    return this;
  }

  @Override
  public AmqpBridgeOptions setTcpKeepAlive(boolean tcpKeepAlive) {
    super.setTcpKeepAlive(tcpKeepAlive);
    return this;
  }

  @Override
  public AmqpBridgeOptions setSoLinger(int soLinger) {
    super.setSoLinger(soLinger);
    return this;
  }

  @Override
  public AmqpBridgeOptions setReusePort(boolean reusePort) {
    super.setReusePort(reusePort);
    return this;
  }

  @Override
  public AmqpBridgeOptions setTcpCork(boolean tcpCork) {
    super.setTcpCork(tcpCork);
    return this;
  }

  @Override
  public AmqpBridgeOptions setTcpFastOpen(boolean tcpFastOpen) {
    super.setTcpFastOpen(tcpFastOpen);
    return this;
  }

  @Override
  public AmqpBridgeOptions setTcpQuickAck(boolean tcpQuickAck) {
    super.setTcpQuickAck(tcpQuickAck);
    return this;
  }

  @Override
  public AmqpBridgeOptions setUsePooledBuffers(boolean usePooledBuffers) {
    super.setUsePooledBuffers(usePooledBuffers);
    return this;
  }

  @Override
  public AmqpBridgeOptions setIdleTimeout(int idleTimeout) {
    super.setIdleTimeout(idleTimeout);
    return this;
  }

  @Override
  public AmqpBridgeOptions setSsl(boolean ssl) {
    super.setSsl(ssl);
    return this;
  }

  @Override
  public AmqpBridgeOptions setKeyStoreOptions(JksOptions options) {
    super.setKeyStoreOptions(options);
    return this;
  }

  @Override
  public AmqpBridgeOptions setPfxKeyCertOptions(PfxOptions options) {
    super.setPfxKeyCertOptions(options);
    return this;
  }

  @Override
  public AmqpBridgeOptions setPemKeyCertOptions(PemKeyCertOptions options) {
    super.setPemKeyCertOptions(options);
    return this;
  }

  @Override
  public AmqpBridgeOptions setTrustStoreOptions(JksOptions options) {
    super.setTrustStoreOptions(options);
    return this;
  }

  @Override
  public AmqpBridgeOptions setPemTrustOptions(PemTrustOptions options) {
    super.setPemTrustOptions(options);
    return this;
  }

  @Override
  public AmqpBridgeOptions setPfxTrustOptions(PfxOptions options) {
    super.setPfxTrustOptions(options);
    return this;
  }

  @Override
  public AmqpBridgeOptions addEnabledCipherSuite(String suite) {
    super.addEnabledCipherSuite(suite);
    return this;
  }

  @Override
  public AmqpBridgeOptions addCrlPath(String crlPath) throws NullPointerException {
    super.addCrlPath(crlPath);
    return this;
  }

  @Override
  public AmqpBridgeOptions addCrlValue(Buffer crlValue) throws NullPointerException {
    super.addCrlValue(crlValue);
    return this;
  }

  @Override
  public AmqpBridgeOptions setTrustAll(boolean trustAll) {
    super.setTrustAll(trustAll);
    return this;
  }

  @Override
  public AmqpBridgeOptions setConnectTimeout(int connectTimeout) {
    super.setConnectTimeout(connectTimeout);
    return this;
  }

  @Override
  public AmqpBridgeOptions setReconnectAttempts(int attempts) {
    super.setReconnectAttempts(attempts);
    return this;
  }

  @Override
  public AmqpBridgeOptions setReconnectInterval(long interval) {
    super.setReconnectInterval(interval);
    return this;
  }

  @Override
  public AmqpBridgeOptions setUseAlpn(boolean useAlpn) {
    throw new UnsupportedOperationException();
  }

  @Override
  public AmqpBridgeOptions addEnabledSecureTransportProtocol(String protocol) {
    super.addEnabledSecureTransportProtocol(protocol);
    return this;
  }

  @Override
  public AmqpBridgeOptions setHostnameVerificationAlgorithm(String hostnameVerificationAlgorithm) {
    super.setHostnameVerificationAlgorithm(hostnameVerificationAlgorithm);
    return this;
  }

  @Override
  public AmqpBridgeOptions setKeyCertOptions(KeyCertOptions options) {
    super.setKeyCertOptions(options);
    return this;
  }

  @Override
  public AmqpBridgeOptions setLogActivity(boolean logEnabled) {
    super.setLogActivity(logEnabled);
    return this;
  }

  @Override
  public AmqpBridgeOptions setMetricsName(String metricsName) {
    super.setMetricsName(metricsName);
    return this;
  }

  @Override
  public AmqpBridgeOptions setProxyOptions(ProxyOptions proxyOptions) {
    super.setProxyOptions(proxyOptions);
    return this;
  }

  @Override
  public AmqpBridgeOptions setTrustOptions(TrustOptions options) {
    super.setTrustOptions(options);
    return this;
  }

  @Override
  public AmqpBridgeOptions setJdkSslEngineOptions(JdkSSLEngineOptions sslEngineOptions) {
    super.setJdkSslEngineOptions(sslEngineOptions);
    return this;
  }

  @Override
  public AmqpBridgeOptions setOpenSslEngineOptions(OpenSSLEngineOptions sslEngineOptions) {
    super.setOpenSslEngineOptions(sslEngineOptions);
    return this;
  }

  @Override
  public AmqpBridgeOptions setSslEngineOptions(SSLEngineOptions sslEngineOptions) {
    super.setSslEngineOptions(sslEngineOptions);
    return this;
  }

  @Override
  public AmqpBridgeOptions setLocalAddress(String localAddress) {
    super.setLocalAddress(localAddress);
    return this;
  }

  @Override
  public int hashCode() {
    final int prime = 31;

    int result = super.hashCode();
    result = prime * result + (replyHandlingSupport ? 1231 : 1237);
    result = prime * result + ((containerId == null) ? 0 : containerId.hashCode());
    result = prime * result + ((vhost == null) ? 0 : vhost.hashCode());

    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    if (!super.equals(obj)) {
      return false;
    }

    AmqpBridgeOptions other = (AmqpBridgeOptions) obj;
    if (replyHandlingSupport != other.replyHandlingSupport) {
      return false;
    }

    if (containerId == null) {
      if (other.containerId != null) {
        return false;
      }
    } else if (!containerId.equals(other.containerId)) {
      return false;
    }

    if (vhost == null) {
      if (other.vhost != null) {
        return false;
      }
    } else if (!vhost.equals(other.vhost)) {
      return false;
    }

    return true;
  }

  @Override
  public AmqpBridgeOptions setVirtualHost(String virtualHost) {
    super.setVirtualHost(virtualHost);
    return this;
  }

  @Override
  public AmqpBridgeOptions setSniServerName(String sniServerName) {
    super.setSniServerName(sniServerName);
    return this;
  }

  @Override
  public AmqpBridgeOptions setMaxFrameSize(int maxFrameSize) {
    super.setMaxFrameSize(maxFrameSize);
    return this;
  }
}
