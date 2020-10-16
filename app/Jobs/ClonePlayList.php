<?php

namespace App\Jobs;

use App\Repositories\Playlist\PlaylistRepositoryInterface;
use App\Models\Playlist;
use App\Models\Project;
use Illuminate\Bus\Queueable;
use Illuminate\Contracts\Queue\ShouldQueue;
use Illuminate\Foundation\Bus\Dispatchable;
use Illuminate\Queue\InteractsWithQueue;
use Illuminate\Queue\SerializesModels;
use App\Notifications\CloneNotification;
use App\Repositories\User\UserRepositoryInterface;
use Illuminate\Support\Facades\Log;
use App\User;

class ClonePlayList implements ShouldQueue
{
    use Dispatchable, InteractsWithQueue, Queueable, SerializesModels;

    /**
     * @var Project
     */
    protected $project;

    /**
     * @var Playlist
     */
    protected $playlist;

    /**
     * @var
     */
    protected $token;


    /**
     * Create a new job instance.
     *
     * @param Project $project
     * @param Playlist $playlist
     * @param $token
     */
    public function __construct(Project $project, Playlist $playlist, $token)
    {
        $this->project = $project;
        $this->playlist = $playlist;
        $this->token = $token;

    }

    /**
     * Execute the job.
     *
     * @param PlaylistRepositoryInterface $playlistRepository
     * @return void
     */
    public function handle(PlaylistRepositoryInterface $playlistRepository, UserRepositoryInterface $userRepository)
    {
        $playlistRepository->clone($this->project, $this->playlist, $this->token);
        $isDuplicate = ($this->playlist->project_id == $this->project->id);
        $process = ($isDuplicate) ? "duplicated" : "cloned";
        $message =  "Playlist(".$this->playlist->title.") has been $process successfully" ;
        (new \App\Events\SendMessage($message));
        $user_id = $userRepository->parseToken($this->token);
        $user = User::find($user_id);
        $user->notify(new CloneNotification($message, $process));
    }
}
