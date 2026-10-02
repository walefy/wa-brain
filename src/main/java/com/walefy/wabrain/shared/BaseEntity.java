package com.walefy.wabrain.shared;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
@SoftDelete(columnName = "deleted_at", strategy = SoftDeleteType.TIMESTAMP)
public class BaseEntity {
  @Id @Generated protected UUID id;

  @Column(name = "created_at", nullable = false, updatable = false)
  @Generated
  protected Instant createdAt;

  @Column(name = "updated_at", nullable = false)
  @UpdateTimestamp
  protected Instant updatedAt;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updateAt) {
    this.updatedAt = updateAt;
  }
}
