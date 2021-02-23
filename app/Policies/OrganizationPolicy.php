<?php

namespace App\Policies;

use App\Models\Organization;
use App\User;
use Illuminate\Auth\Access\HandlesAuthorization;

class OrganizationPolicy
{
    use HandlesAuthorization;

    /**
     * Determine whether the user can view any suborganization.
     *
     * @param  User  $user
     * @return mixed
     */
    public function viewAny(User $user)
    {
        return $this->getUserDefaultOrganizationRole($user, $user->defaultOrganization) == 1;
    }

    /**
     * Determine whether the user can view the suborganization.
     *
     * @param  User  $user
     * @param  Organization  $organization
     * @return mixed
     */
    public function view(User $user, Organization $organization)
    {
        return $this->getUserDefaultOrganizationRole($user, $organization) == 1;
    }

    /**
     * Determine whether the user can create suborganization.
     *
     * @param  User  $user
     * @return mixed
     */
    public function create(User $user)
    {
        return $this->getUserDefaultOrganizationRole($user, $user->defaultOrganization) == 1;
    }

    /**
     * Determine whether the user can upload thumb.
     *
     * @param User $user
     * @return mixed
     */
    public function uploadThumb(User $user)
    {
        return $this->getUserDefaultOrganizationRole($user, $user->defaultOrganization) == 1;
    }

    /**
     * Determine whether the user can view member options.
     *
     * @param User $user
     * @return mixed
     */
    public function viewMemberOptions(User $user)
    {
        return in_array($this->getUserDefaultOrganizationRole($user, $user->defaultOrganization), [1, 2]);
    }

    /**
     * Determine whether the user can add user.
     *
     * @param User $user
     * @param Organization $organization
     * @return mixed
     */
    public function addUser(User $user, Organization $organization)
    {
        return in_array($this->getUserDefaultOrganizationRole($user, $organization), [1, 2]);
    }

    /**
     * Determine whether the user can invite members.
     *
     * @param User $user
     * @return mixed
     */
    public function inviteMembers(User $user)
    {
        return in_array($this->getUserDefaultOrganizationRole($user, $user->defaultOrganization), [1, 2]);
    }

    /**
     * Determine whether the user can update user.
     *
     * @param User $user
     * @return mixed
     */
    public function updateUser(User $user)
    {
        return in_array($this->getUserDefaultOrganizationRole($user, $user->defaultOrganization), [1, 2]);
    }

    /**
     * Determine whether the user can delete user.
     *
     * @param User $user
     * @return mixed
     */
    public function deleteUser(User $user)
    {
        return in_array($this->getUserDefaultOrganizationRole($user, $user->defaultOrganization), [1, 2]);
    }

    /**
     * Determine whether the user can view any user.
     *
     * @param User $user
     * @return mixed
     */
    public function viewAnyUser(User $user)
    {
        return in_array($this->getUserDefaultOrganizationRole($user, $user->defaultOrganization), [1, 2]);
    }

    /**
     * Determine whether the user can update the model.
     *
     * @param  User  $user
     * @param  Organization  $organization
     * @return mixed
     */
    public function update(User $user, Organization $organization)
    {
        return $this->getUserDefaultOrganizationRole($user, $organization) == 1;
    }

    /**
     * Determine whether the user can delete the model.
     *
     * @param  \App\User  $user
     * @param  \App\Organization  $organization
     * @return mixed
     */
    public function delete(User $user, Organization $organization)
    {
        return $this->getUserDefaultOrganizationRole($user, $organization) == 1;
    }

    /**
     * Determine whether the user can restore the model.
     *
     * @param  \App\User  $user
     * @param  \App\Organization  $organization
     * @return mixed
     */
    public function restore(User $user, Organization $organization)
    {
        //
    }

    /**
     * Determine whether the user can permanently delete the model.
     *
     * @param  \App\User  $user
     * @param  \App\Organization  $organization
     * @return mixed
     */
    public function forceDelete(User $user, Organization $organization)
    {
        //
    }

    /**
     * Get user default organization role
     *
     * @param  User  $user
     * @param  Organization  $organization
     * @return mixed
     */
    private function getUserDefaultOrganizationRole(User $user, Organization  $organization)
    {
        $defaultOrganization = $user->organizations()->wherePivot('organization_id', $organization->id)->first();

        if ($defaultOrganization) {
            return $defaultOrganization->pivot->organization_role_type_id;
        } else {
            return $this->getUserDefaultOrganizationRole($user, $organization->parent);
        }

        return 0;
    }
}
